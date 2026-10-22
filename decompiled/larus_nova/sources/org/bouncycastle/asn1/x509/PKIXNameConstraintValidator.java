package org.bouncycastle.asn1.x509;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.UByte;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXNameConstraintValidator implements NameConstraintValidator {
    private Set excludedSubtreesDN;
    private Set excludedSubtreesDNS;
    private Set excludedSubtreesEmail;
    private Set excludedSubtreesIP;
    private Set excludedSubtreesOtherName;
    private Set excludedSubtreesURI;
    private Set permittedSubtreesDN;
    private Set permittedSubtreesDNS;
    private Set permittedSubtreesEmail;
    private Set permittedSubtreesIP;
    private Set permittedSubtreesOtherName;
    private Set permittedSubtreesURI;

    public PKIXNameConstraintValidator() {
        this.excludedSubtreesDN = new HashSet();
        this.excludedSubtreesDNS = new HashSet();
        this.excludedSubtreesEmail = new HashSet();
        this.excludedSubtreesURI = new HashSet();
        this.excludedSubtreesIP = new HashSet();
        this.excludedSubtreesOtherName = new HashSet();
    }

    private final void addLine(StringBuilder r100, String r101) {
        r100.append(r101);
        r100.append(Strings.lineSeparator());
    }

    private void checkExcludedDN(Set r100, ASN1Sequence r101) throws NameConstraintValidatorException {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        if (withinDNSubtree(r101, (ASN1Sequence) r102.next()) == false) goto L7;
        throw new NameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
    }

    private void checkExcludedDNS(Set r100, String r101) throws NameConstraintValidatorException {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        String r103 = (String) r102.next();
        if (withinDomain(r101, r103) == true) goto L14;
        if (r101.equalsIgnoreCase(r103) == false) goto L7;
    L14:
        throw new NameConstraintValidatorException("DNS is from an excluded subtree.");
    }

    private void checkExcludedEmail(Set r100, String r101) throws NameConstraintValidatorException {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        if (emailIsConstrained(r101, (String) r102.next()) == false) goto L7;
        throw new NameConstraintValidatorException("Email address is from an excluded subtree.");
    }

    private void checkExcludedIP(Set r100, byte[] r101) throws NameConstraintValidatorException {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        if (isIPConstrained(r101, (byte[]) r102.next()) == false) goto L7;
        throw new NameConstraintValidatorException("IP is from an excluded subtree.");
    }

    private void checkExcludedOtherName(Set r100, OtherName r101) throws NameConstraintValidatorException {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        if (otherNameIsConstrained(r101, OtherName.getInstance(r102.next())) == false) goto L7;
        throw new NameConstraintValidatorException("OtherName is from an excluded subtree.");
    }

    private void checkExcludedURI(Set r100, String r101) throws NameConstraintValidatorException {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        if (isUriConstrained(r101, (String) r102.next()) == false) goto L7;
        throw new NameConstraintValidatorException("URI is from an excluded subtree.");
    }

    private void checkPermittedDN(Set r100, ASN1Sequence r101) throws NameConstraintValidatorException {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L7;
    L9:
        Iterator r102 = r100.iterator();
    L11:
        if (r102.hasNext() == false) goto L16;
        if (withinDNSubtree(r101, (ASN1Sequence) r102.next()) == false) goto L11;
        return;
    L16:
        throw new NameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
    L7:
        if (r101.size() != 0) goto L9;
    }

    private void checkPermittedDNS(Set r100, String r101) throws NameConstraintValidatorException {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        String r103 = (String) r102.next();
        if (withinDomain(r101, r103) == true) goto L11;
        if (r101.equalsIgnoreCase(r103) == false) goto L6;
        return;
    L11:
        return;
    L13:
        if (r101.length() != 0) goto L18;
        if (r100.size() != 0) goto L18;
        return;
    L18:
        throw new NameConstraintValidatorException("DNS is not from a permitted subtree.");
    }

    private void checkPermittedEmail(Set r100, String r101) throws NameConstraintValidatorException {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        if (emailIsConstrained(r101, (String) r102.next()) == false) goto L6;
        return;
    L11:
        if (r101.length() != 0) goto L16;
        if (r100.size() != 0) goto L16;
        return;
    L16:
        throw new NameConstraintValidatorException("Subject email address is not from a permitted subtree.");
    }

    private void checkPermittedIP(Set r100, byte[] r101) throws NameConstraintValidatorException {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        if (isIPConstrained(r101, (byte[]) r102.next()) == false) goto L6;
        return;
    L11:
        if (r101.length != 0) goto L16;
        if (r100.size() != 0) goto L16;
        return;
    L16:
        throw new NameConstraintValidatorException("IP is not from a permitted subtree.");
    }

    private void checkPermittedOtherName(Set r100, OtherName r101) throws NameConstraintValidatorException {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        if (otherNameIsConstrained(r101, OtherName.getInstance(r102.next())) == false) goto L6;
        return;
    L11:
        throw new NameConstraintValidatorException("Subject OtherName is not from a permitted subtree.");
    }

    private void checkPermittedURI(Set r100, String r101) throws NameConstraintValidatorException {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        if (isUriConstrained(r101, (String) r102.next()) == false) goto L6;
        return;
    L11:
        if (r101.length() != 0) goto L16;
        if (r100.size() != 0) goto L16;
        return;
    L16:
        throw new NameConstraintValidatorException("URI is not from a permitted subtree.");
    }

    private boolean collectionsAreEqual(Collection r100, Collection r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        if (r100.size() == r101.size()) goto L12;
        return false;
    L12:
        Iterator r102 = r100.iterator();
    L14:
        if (r102.hasNext() == false) goto L24;
        Object r103 = r102.next();
        Iterator r104 = r101.iterator();
    L17:
        if (r104.hasNext() == false) goto L21;
        if (equals(r103, r104.next()) == false) goto L17;
        boolean r105 = true;
    L22:
        if (r105 == true) goto L14;
        return false;
    L21:
        r105 = false;
        goto L22
    L24:
        return true;
    L25:
        return false;
    }

    private static int compareTo(byte[] r100, byte[] r101) {
        if (Arrays.areEqual(r100, r101) == false) goto L7;
        return 0;
    L7:
        if (Arrays.areEqual(max(r100, r101), r100) == false) goto L10;
        return 1;
    L10:
        return -1;
    }

    private boolean emailIsConstrained(String r100, String r101) {
        String r102 = r100.substring(r100.indexOf(64) + 1);
        if (r101.indexOf(64) == (-1)) goto L11;
        if (r100.equalsIgnoreCase(r101) == false) goto L8;
        return true;
    L8:
        if (r102.equalsIgnoreCase(r101.substring(1)) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (r101.charAt(0) == '.') goto L16;
        if (r102.equalsIgnoreCase(r101) == false) goto L18;
        return true;
    L16:
        if (withinDomain(r102, r101) == false) goto L18;
        return true;
    }

    private boolean equals(Object r100, Object r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 == null) goto L16;
        if (r101 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof byte[]) == false) goto L15;
        if ((r101 instanceof byte[]) == false) goto L15;
        return Arrays.areEqual((byte[]) r100, (byte[]) r101);
    L15:
        return r100.equals(r101);
    L16:
        return false;
    }

    private static String extractHostFromURL(String r100) {
        String r101 = r100.substring(r100.indexOf(58) + 1);
        if (r101.indexOf("//") == (-1)) goto L6;
        r101 = r101.substring(r101.indexOf("//") + 2);
    L6:
        if (r101.lastIndexOf(58) == (-1)) goto L8;
        r101 = r101.substring(0, r101.lastIndexOf(58));
    L8:
        String r102 = r101.substring(r101.indexOf(58) + 1);
        String r103 = r102.substring(r102.indexOf(64) + 1);
        if (r103.indexOf(47) != (-1)) goto L11;
        return r103;
    L11:
        return r103.substring(0, r103.indexOf(47));
    }

    private byte[][] extractIPsAndSubnetMasks(byte[] r100, byte[] r101) {
        int r102 = r100.length / 2;
        byte[] r103 = new byte[r102];
        byte[] r104 = new byte[r102];
        System.arraycopy(r100, 0, r103, 0, r102);
        System.arraycopy(r100, r102, r104, 0, r102);
        byte[] r105 = new byte[r102];
        byte[] r106 = new byte[r102];
        System.arraycopy(r101, 0, r105, 0, r102);
        System.arraycopy(r101, r102, r106, 0, r102);
        return new byte[][]{r103, r104, r105, r106};
    }

    private String extractNameAsString(GeneralName r100) {
        return DERIA5String.getInstance(r100.getName()).getString();
    }

    private int hashCollection(Collection r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if ((r103 instanceof byte[]) == false) goto L11;
        int r104 = Arrays.hashCode((byte[]) r103);
    L12:
        r101 = r101 + r104;
        goto L7
    L11:
        r104 = r103.hashCode();
        goto L12
    L13:
        return r101;
    }

    private Set intersectDN(Set r100, Set r101) {
        HashSet r102 = new HashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L18;
        ASN1Sequence r104 = ASN1Sequence.getInstance(((GeneralSubtree) r103.next()).getBase().getName().toASN1Primitive());
        if (r100 == null) goto L7;
        Iterator r105 = r100.iterator();
    L11:
        if (r105.hasNext() == false) goto L4;
        ASN1Sequence r106 = (ASN1Sequence) r105.next();
        if (withinDNSubtree(r104, r106) == true) goto L14;
        if (withinDNSubtree(r106, r104) == false) goto L11;
        r102.add(r106);
        goto L11
    L14:
        r102.add(r104);
        goto L11
    L7:
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L18:
        return r102;
    }

    private Set intersectDNS(Set r100, Set r101) {
        HashSet r102 = new HashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L18;
        String r104 = extractNameAsString(((GeneralSubtree) r103.next()).getBase());
        if (r100 == null) goto L7;
        Iterator r105 = r100.iterator();
    L11:
        if (r105.hasNext() == false) goto L4;
        String r106 = (String) r105.next();
        if (withinDomain(r106, r104) == true) goto L14;
        if (withinDomain(r104, r106) == false) goto L11;
        r102.add(r104);
        goto L11
    L14:
        r102.add(r106);
        goto L11
    L7:
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L18:
        return r102;
    }

    private Set intersectEmail(Set r100, Set r101) {
        HashSet r102 = new HashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        String r104 = extractNameAsString(((GeneralSubtree) r103.next()).getBase());
        if (r100 == null) goto L7;
        Iterator r105 = r100.iterator();
    L11:
        if (r105.hasNext() == false) goto L4;
        intersectEmail(r104, (String) r105.next(), r102);
        goto L11
    L7:
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L13:
        return r102;
    }

    private void intersectEmail(String r100, String r101, Set r102) {
        if (r100.indexOf(64) == (-1)) goto L18;
        String r103 = r100.substring(r100.indexOf(64) + 1);
        if (r101.indexOf(64) == (-1)) goto L10;
        if (r100.equalsIgnoreCase(r101) == false) goto L51;
    L49:
        r102.add(r100);
        return;
    L51:
        return;
    L10:
        if (r101.startsWith(".") == false) goto L15;
        if (withinDomain(r103, r101) == true) goto L49;
        return;
    L15:
        if (r103.equalsIgnoreCase(r101) == true) goto L49;
        return;
    L18:
        if (r100.startsWith(".") == false) goto L38;
        if (r101.indexOf(64) == (-1)) goto L25;
        if (withinDomain(r101.substring(r100.indexOf(64) + 1), r100) == false) goto L54;
    L36:
        r102.add(r101);
        return;
    L54:
        return;
    L25:
        if (r101.startsWith(".") == false) goto L35;
        if (withinDomain(r100, r101) == true) goto L49;
        if (r100.equalsIgnoreCase(r101) == true) goto L49;
        if (withinDomain(r101, r100) == true) goto L36;
        return;
    L35:
        if (withinDomain(r101, r100) == true) goto L36;
        return;
    L38:
        if (r101.indexOf(64) == (-1)) goto L43;
        if (r101.substring(r101.indexOf(64) + 1).equalsIgnoreCase(r100) == true) goto L36;
        return;
    L43:
        if (r101.startsWith(".") == false) goto L48;
        if (withinDomain(r100, r101) == true) goto L49;
        return;
    L48:
        if (r100.equalsIgnoreCase(r101) == true) goto L49;
    }

    private Set intersectIP(Set r100, Set r101) {
        HashSet r102 = new HashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        byte[] r104 = ASN1OctetString.getInstance(((GeneralSubtree) r103.next()).getBase().getName()).getOctets();
        if (r100 == null) goto L7;
        Iterator r105 = r100.iterator();
    L11:
        if (r105.hasNext() == false) goto L4;
        r102.addAll(intersectIPRange((byte[]) r105.next(), r104));
        goto L11
    L7:
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L13:
        return r102;
    }

    private Set intersectIPRange(byte[] r100, byte[] r101) {
        if (r100.length != r101.length) goto L5;
        byte[][] r102 = extractIPsAndSubnetMasks(r100, r101);
        byte[] r103 = r102[0];
        byte[] r104 = r102[1];
        byte[] r105 = r102[2];
        byte[] r106 = r102[3];
        byte[][] r107 = minMaxIPs(r103, r104, r105, r106);
        byte[] r108 = min(r107[1], r107[3]);
        if (compareTo(max(r107[0], r107[2]), r108) != 1) goto L11;
        return Collections.EMPTY_SET;
    L11:
        return Collections.singleton(ipWithSubnetMask(or(r107[0], r107[2]), or(r104, r106)));
    L5:
        return Collections.EMPTY_SET;
    }

    private Set intersectOtherName(Set r100, Set r101) {
        HashSet r102 = new HashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        OtherName r104 = OtherName.getInstance(((GeneralSubtree) r103.next()).getBase().getName());
        if (r100 == null) goto L7;
        Iterator r105 = r100.iterator();
    L11:
        if (r105.hasNext() == false) goto L4;
        intersectOtherName(r104, OtherName.getInstance(r105.next()), r102);
        goto L11
    L7:
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L13:
        return r102;
    }

    private void intersectOtherName(OtherName r100, OtherName r101, Set r102) {
        if (r100.equals(r101) == false) goto L6;
        r102.add(r100);
        return;
    }

    private Set intersectURI(Set r100, Set r101) {
        HashSet r102 = new HashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        String r104 = extractNameAsString(((GeneralSubtree) r103.next()).getBase());
        if (r100 == null) goto L7;
        Iterator r105 = r100.iterator();
    L11:
        if (r105.hasNext() == false) goto L4;
        intersectURI((String) r105.next(), r104, r102);
        goto L11
    L7:
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L13:
        return r102;
    }

    private void intersectURI(String r100, String r101, Set r102) {
        if (r100.indexOf(64) == (-1)) goto L18;
        String r103 = r100.substring(r100.indexOf(64) + 1);
        if (r101.indexOf(64) == (-1)) goto L10;
        if (r100.equalsIgnoreCase(r101) == false) goto L51;
    L49:
        r102.add(r100);
        return;
    L51:
        return;
    L10:
        if (r101.startsWith(".") == false) goto L15;
        if (withinDomain(r103, r101) == true) goto L49;
        return;
    L15:
        if (r103.equalsIgnoreCase(r101) == true) goto L49;
        return;
    L18:
        if (r100.startsWith(".") == false) goto L38;
        if (r101.indexOf(64) == (-1)) goto L25;
        if (withinDomain(r101.substring(r100.indexOf(64) + 1), r100) == false) goto L54;
    L36:
        r102.add(r101);
        return;
    L54:
        return;
    L25:
        if (r101.startsWith(".") == false) goto L35;
        if (withinDomain(r100, r101) == true) goto L49;
        if (r100.equalsIgnoreCase(r101) == true) goto L49;
        if (withinDomain(r101, r100) == true) goto L36;
        return;
    L35:
        if (withinDomain(r101, r100) == true) goto L36;
        return;
    L38:
        if (r101.indexOf(64) == (-1)) goto L43;
        if (r101.substring(r101.indexOf(64) + 1).equalsIgnoreCase(r100) == true) goto L36;
        return;
    L43:
        if (r101.startsWith(".") == false) goto L48;
        if (withinDomain(r100, r101) == true) goto L49;
        return;
    L48:
        if (r100.equalsIgnoreCase(r101) == true) goto L49;
    }

    private byte[] ipWithSubnetMask(byte[] r100, byte[] r101) {
        int r102 = r100.length;
        byte[] r103 = new byte[r102 * 2];
        System.arraycopy(r100, 0, r103, 0, r102);
        System.arraycopy(r101, 0, r103, r102, r102);
        return r103;
    }

    private boolean isIPConstrained(byte[] r100, byte[] r101) {
        int r102 = r100.length;
        int r103 = 0;
        if (r102 == (r101.length / 2)) goto L5;
        return false;
    L5:
        byte[] r104 = new byte[r102];
        System.arraycopy(r101, r102, r104, 0, r102);
        byte[] r105 = new byte[r102];
        byte[] r106 = new byte[r102];
    L6:
        if (r103 >= r102) goto L9;
        r105[r103] = (byte) (r101[r103] & r104[r103]);
        r106[r103] = (byte) (r100[r103] & r104[r103]);
        r103 = r103 + 1;
        goto L6
    L9:
        return Arrays.areEqual(r105, r106);
    }

    private boolean isUriConstrained(String r100, String r101) {
        String r102 = extractHostFromURL(r100);
        if (r101.startsWith(".") == true) goto L8;
        if (r102.equalsIgnoreCase(r101) == false) goto L10;
        return true;
    L10:
        return false;
    L8:
        if (withinDomain(r102, r101) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static byte[] max(byte[] r100, byte[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L9;
        if ((r100[r102] & UByte.MAX_VALUE) > (65535 & r101[r102])) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return r100;
    L9:
        return r101;
    }

    private static byte[] min(byte[] r100, byte[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L9;
        if ((r100[r102] & UByte.MAX_VALUE) < (65535 & r101[r102])) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return r100;
    L9:
        return r101;
    }

    private byte[][] minMaxIPs(byte[] r110, byte[] r111, byte[] r112, byte[] r113) {
        int r100 = r110.length;
        byte[] r101 = new byte[r100];
        byte[] r102 = new byte[r100];
        byte[] r103 = new byte[r100];
        byte[] r104 = new byte[r100];
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L6;
        r101[r105] = (byte) (r110[r105] & r111[r105]);
        byte r106 = r110[r105];
        byte r107 = r111[r105];
        r102[r105] = (byte) ((r106 & r107) | (~r107));
        r103[r105] = (byte) (r112[r105] & r113[r105]);
        byte r108 = r112[r105];
        byte r109 = r113[r105];
        r104[r105] = (byte) ((r108 & r109) | (~r109));
        r105 = r105 + 1;
        goto L3
    L6:
        return new byte[][]{r101, r102, r103, r104};
    }

    private static byte[] or(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = (byte) (r100[r103] | r101[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    private boolean otherNameIsConstrained(OtherName r100, OtherName r101) {
        if (r101.equals(r100) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private String stringifyIP(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L4:
        if (r102 >= (r100.length / 2)) goto L9;
        if (r101.length() <= 0) goto L8;
        r101.append(".");
    L8:
        r101.append(Integer.toString(r100[r102] & UByte.MAX_VALUE));
        r102 = r102 + 1;
        goto L4
    L9:
        r101.append(HTTP.URL_DEFAULT);
        int r103 = r100.length / 2;
        boolean r104 = true;
    L11:
        if (r103 >= r100.length) goto L17;
        if (r104 == false) goto L14;
        r104 = false;
    L15:
        r101.append(Integer.toString(r100[r103] & UByte.MAX_VALUE));
        r103 = r103 + 1;
        goto L11
    L14:
        r101.append(".");
        goto L15
    L17:
        return r101.toString();
    }

    private String stringifyIPCollection(Set r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("[");
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r101.length() <= 1) goto L8;
        r101.append(",");
    L8:
        r101.append(stringifyIP((byte[]) r102.next()));
        goto L4
    L9:
        r101.append("]");
        return r101.toString();
    }

    private String stringifyOtherNameCollection(Set r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("[");
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        if (r101.length() <= 1) goto L8;
        r101.append(",");
    L8:
        OtherName r103 = OtherName.getInstance(r102.next());
        r101.append(r103.getTypeID().getId());
        r101.append(":");
        r101.append(Hex.toHexString(r103.getValue().toASN1Primitive().getEncoded()));     // Catch: IOException -> L11
    L11:
        e = move-exception;
        r101.append(e.toString());
        goto L4
    L13:
        r101.append("]");
        return r101.toString();
    }

    private Set unionDN(Set r100, ASN1Sequence r101) {
        if (r100.isEmpty() == false) goto L8;
        if (r101 != null) goto L6;
        return r100;
    L6:
        r100.add(r101);
        return r100;
    L8:
        HashSet r102 = new HashSet();
        Iterator r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L19;
        ASN1Sequence r104 = ASN1Sequence.getInstance(r103.next());
        if (withinDNSubtree(r101, r104) == true) goto L13;
        if (withinDNSubtree(r104, r101) == true) goto L18;
        r102.add(r104);
    L18:
        r102.add(r101);
        goto L10
    L13:
        r102.add(r104);
        goto L10
    L19:
        return r102;
    }

    private Set unionDNS(Set r100, String r101) {
        if (r100.isEmpty() == false) goto L8;
        if (r101 != null) goto L6;
        return r100;
    L6:
        r100.add(r101);
        return r100;
    L8:
        HashSet r102 = new HashSet();
        Iterator r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        String r104 = (String) r103.next();
        if (withinDomain(r104, r101) == true) goto L13;
        boolean r105 = withinDomain(r101, r104);
        r102.add(r104);
        if (r105 == true) goto L10;
    L13:
        r102.add(r101);
        goto L10
    L17:
        return r102;
    }

    private Set unionEmail(Set r100, String r101) {
        if (r100.isEmpty() == false) goto L8;
        if (r101 != null) goto L6;
        return r100;
    L6:
        r100.add(r101);
        return r100;
    L8:
        HashSet r102 = new HashSet();
        Iterator r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        unionEmail((String) r103.next(), r101, r102);
        goto L10
    L12:
        return r102;
    }

    private void unionEmail(String r100, String r101, Set r102) {
        if (r100.indexOf(64) == (-1)) goto L18;
        String r103 = r100.substring(r100.indexOf(64) + 1);
        if (r101.indexOf(64) == (-1)) goto L10;
        if (r100.equalsIgnoreCase(r101) == true) goto L49;
    L50:
        r102.add(r100);
    L51:
        r102.add(r101);
        return;
    L49:
        r102.add(r100);
        return;
    L10:
        if (r101.startsWith(".") == false) goto L15;
        if (withinDomain(r103, r101) == false) goto L50;
    L15:
        if (r103.equalsIgnoreCase(r101) == false) goto L50;
    L18:
        if (r100.startsWith(".") == false) goto L38;
        if (r101.indexOf(64) == (-1)) goto L25;
        if (withinDomain(r101.substring(r100.indexOf(64) + 1), r100) == false) goto L50;
    L25:
        if (r101.startsWith(".") == false) goto L35;
        if (withinDomain(r100, r101) == true) goto L51;
        if (r100.equalsIgnoreCase(r101) == true) goto L51;
        if (withinDomain(r101, r100) == false) goto L50;
    L35:
        if (withinDomain(r101, r100) == false) goto L50;
    L38:
        if (r101.indexOf(64) == (-1)) goto L43;
        if (r101.substring(r100.indexOf(64) + 1).equalsIgnoreCase(r100) == false) goto L50;
    L43:
        if (r101.startsWith(".") == false) goto L48;
        if (withinDomain(r100, r101) == false) goto L50;
    L48:
        if (r100.equalsIgnoreCase(r101) == false) goto L50;
        goto L49
    }

    private Set unionIP(Set r100, byte[] r101) {
        if (r100.isEmpty() == false) goto L8;
        if (r101 != null) goto L6;
        return r100;
    L6:
        r100.add(r101);
        return r100;
    L8:
        HashSet r102 = new HashSet();
        Iterator r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        r102.addAll(unionIPRange((byte[]) r103.next(), r101));
        goto L10
    L12:
        return r102;
    }

    private Set unionIPRange(byte[] r100, byte[] r101) {
        HashSet r102 = new HashSet();
        boolean r103 = Arrays.areEqual(r100, r101);
        r102.add(r100);
        if (r103 == true) goto L6;
        r102.add(r101);
    L6:
        return r102;
    }

    private Set unionOtherName(Set r100, OtherName r101) {
        if (r100 == null) goto L5;
        HashSet r102 = new HashSet(r100);
    L6:
        r102.add(r101);
        return r102;
    L5:
        r102 = new HashSet();
        goto L6
    }

    private Set unionURI(Set r100, String r101) {
        if (r100.isEmpty() == false) goto L8;
        if (r101 != null) goto L6;
        return r100;
    L6:
        r100.add(r101);
        return r100;
    L8:
        HashSet r102 = new HashSet();
        Iterator r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        unionURI((String) r103.next(), r101, r102);
        goto L10
    L12:
        return r102;
    }

    private void unionURI(String r100, String r101, Set r102) {
        if (r100.indexOf(64) == (-1)) goto L18;
        String r103 = r100.substring(r100.indexOf(64) + 1);
        if (r101.indexOf(64) == (-1)) goto L10;
        if (r100.equalsIgnoreCase(r101) == true) goto L49;
    L50:
        r102.add(r100);
    L51:
        r102.add(r101);
        return;
    L49:
        r102.add(r100);
        return;
    L10:
        if (r101.startsWith(".") == false) goto L15;
        if (withinDomain(r103, r101) == false) goto L50;
    L15:
        if (r103.equalsIgnoreCase(r101) == false) goto L50;
    L18:
        if (r100.startsWith(".") == false) goto L38;
        if (r101.indexOf(64) == (-1)) goto L25;
        if (withinDomain(r101.substring(r100.indexOf(64) + 1), r100) == false) goto L50;
    L25:
        if (r101.startsWith(".") == false) goto L35;
        if (withinDomain(r100, r101) == true) goto L51;
        if (r100.equalsIgnoreCase(r101) == true) goto L51;
        if (withinDomain(r101, r100) == false) goto L50;
    L35:
        if (withinDomain(r101, r100) == false) goto L50;
    L38:
        if (r101.indexOf(64) == (-1)) goto L43;
        if (r101.substring(r100.indexOf(64) + 1).equalsIgnoreCase(r100) == false) goto L50;
    L43:
        if (r101.startsWith(".") == false) goto L48;
        if (withinDomain(r100, r101) == false) goto L50;
    L48:
        if (r100.equalsIgnoreCase(r101) == false) goto L50;
        goto L49
    }

    private static boolean withinDNSubtree(ASN1Sequence r100, ASN1Sequence r110) {
        if (r110.size() >= 1) goto L6;
        return false;
    L6:
        if (r110.size() <= r100.size()) goto L8;
        return false;
    L8:
        RDN r101 = RDN.getInstance(r110.getObjectAt(0));
        int r102 = 0;
        int r103 = 0;
    L10:
        if (r102 >= r100.size()) goto L15;
        if (IETFUtils.rDNAreEqual(r101, RDN.getInstance(r100.getObjectAt(r102))) == true) goto L17;
        r103 = r102;
        r102 = r102 + 1;
    L17:
        if (r110.size() <= (r100.size() - r102)) goto L19;
        return false;
    L19:
        int r104 = 0;
    L21:
        if (r104 >= r110.size()) goto L39;
        RDN r105 = RDN.getInstance(r110.getObjectAt(r104));
        RDN r106 = RDN.getInstance(r100.getObjectAt(r102 + r104));
        if (r105.size() != r106.size()) goto L38;
        if (r105.getFirst().getType().equals(r106.getFirst().getType()) == false) goto L26;
        if (r105.size() != 1) goto L35;
        if (r105.getFirst().getType().equals(RFC4519Style.serialNumber) == false) goto L35;
        if (r106.getFirst().getValue().toString().startsWith(r105.getFirst().getValue().toString()) == true) goto L37;
        return false;
    L37:
        r104 = r104 + 1;
    L35:
        if (IETFUtils.rDNAreEqual(r105, r106) == true) goto L37;
        return false;
    L26:
        return false;
    L38:
        return false;
    L39:
        return true;
    L15:
        r102 = r103;
        goto L17
    }

    private boolean withinDomain(String r100, String r101) {
        if (r101.startsWith(".") == false) goto L5;
        r101 = r101.substring(1);
    L5:
        String[] r102 = Strings.split(r101, '.');
        String[] r103 = Strings.split(r100, '.');
        if (r103.length > r102.length) goto L8;
        return false;
    L8:
        int r104 = r103.length - r102.length;
        int r105 = -1;
    L10:
        if (r105 >= r102.length) goto L19;
        if (r105 != (-1)) goto L16;
        if (r103[r105 + r104].equals("") == false) goto L18;
        return false;
    L18:
        r105 = r105 + 1;
        goto L10
    L16:
        if (r102[r105].equalsIgnoreCase(r103[r105 + r104]) == true) goto L18;
        return false;
    L19:
        return true;
    }

    @Override // org.bouncycastle.asn1.x509.NameConstraintValidator
    public void addExcludedSubtree(GeneralSubtree r100) {
        GeneralName r101 = r100.getBase();
        int r102 = r101.getTagNo();
        if (r102 != 0) goto L5;
        this.excludedSubtreesOtherName = unionOtherName(this.excludedSubtreesOtherName, OtherName.getInstance(r101.getName()));
        return;
    L5:
        if (r102 != 1) goto L7;
        this.excludedSubtreesEmail = unionEmail(this.excludedSubtreesEmail, extractNameAsString(r101));
        return;
    L7:
        if (r102 != 2) goto L9;
        this.excludedSubtreesDNS = unionDNS(this.excludedSubtreesDNS, extractNameAsString(r101));
        return;
    L9:
        if (r102 != 4) goto L11;
        this.excludedSubtreesDN = unionDN(this.excludedSubtreesDN, (ASN1Sequence) r101.getName().toASN1Primitive());
        return;
    L11:
        if (r102 != 6) goto L13;
        this.excludedSubtreesURI = unionURI(this.excludedSubtreesURI, extractNameAsString(r101));
        return;
    L13:
        if (r102 != 7) goto L16;
        this.excludedSubtreesIP = unionIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(r101.getName()).getOctets());
        return;
    L16:
        throw new IllegalStateException("Unknown tag encountered: " + r101.getTagNo());
    }

    @Override // org.bouncycastle.asn1.x509.NameConstraintValidator
    public void checkExcluded(GeneralName r100) throws NameConstraintValidatorException {
        int r101 = r100.getTagNo();
        if (r101 != 0) goto L5;
        checkExcludedOtherName(this.excludedSubtreesOtherName, OtherName.getInstance(r100.getName()));
        return;
    L5:
        if (r101 != 1) goto L7;
        checkExcludedEmail(this.excludedSubtreesEmail, extractNameAsString(r100));
        return;
    L7:
        if (r101 != 2) goto L9;
        checkExcludedDNS(this.excludedSubtreesDNS, extractNameAsString(r100));
        return;
    L9:
        if (r101 != 4) goto L11;
        checkExcludedDN(X500Name.getInstance(r100.getName()));
        return;
    L11:
        if (r101 != 6) goto L13;
        checkExcludedURI(this.excludedSubtreesURI, extractNameAsString(r100));
        return;
    L13:
        if (r101 != 7) goto L27;
        checkExcludedIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(r100.getName()).getOctets());
        return;
    }

    public void checkExcludedDN(X500Name r100) throws NameConstraintValidatorException {
        checkExcludedDN(this.excludedSubtreesDN, ASN1Sequence.getInstance(r100));
    }

    @Override // org.bouncycastle.asn1.x509.NameConstraintValidator
    public void checkPermitted(GeneralName r100) throws NameConstraintValidatorException {
        int r101 = r100.getTagNo();
        if (r101 != 0) goto L5;
        checkPermittedOtherName(this.permittedSubtreesOtherName, OtherName.getInstance(r100.getName()));
        return;
    L5:
        if (r101 != 1) goto L7;
        checkPermittedEmail(this.permittedSubtreesEmail, extractNameAsString(r100));
        return;
    L7:
        if (r101 != 2) goto L9;
        checkPermittedDNS(this.permittedSubtreesDNS, extractNameAsString(r100));
        return;
    L9:
        if (r101 != 4) goto L11;
        checkPermittedDN(X500Name.getInstance(r100.getName()));
        return;
    L11:
        if (r101 != 6) goto L13;
        checkPermittedURI(this.permittedSubtreesURI, extractNameAsString(r100));
        return;
    L13:
        if (r101 != 7) goto L27;
        checkPermittedIP(this.permittedSubtreesIP, ASN1OctetString.getInstance(r100.getName()).getOctets());
        return;
    }

    public void checkPermittedDN(X500Name r100) throws NameConstraintValidatorException {
        checkPermittedDN(this.permittedSubtreesDN, ASN1Sequence.getInstance(r100.toASN1Primitive()));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PKIXNameConstraintValidator) == true) goto L5;
        return false;
    L5:
        PKIXNameConstraintValidator r101 = (PKIXNameConstraintValidator) r100;
        if (collectionsAreEqual(r101.excludedSubtreesDN, this.excludedSubtreesDN) == true) goto L8;
        return false;
    L8:
        if (collectionsAreEqual(r101.excludedSubtreesDNS, this.excludedSubtreesDNS) == true) goto L10;
        return false;
    L10:
        if (collectionsAreEqual(r101.excludedSubtreesEmail, this.excludedSubtreesEmail) == true) goto L12;
        return false;
    L12:
        if (collectionsAreEqual(r101.excludedSubtreesIP, this.excludedSubtreesIP) == true) goto L14;
        return false;
    L14:
        if (collectionsAreEqual(r101.excludedSubtreesURI, this.excludedSubtreesURI) == true) goto L16;
        return false;
    L16:
        if (collectionsAreEqual(r101.excludedSubtreesOtherName, this.excludedSubtreesOtherName) == true) goto L18;
        return false;
    L18:
        if (collectionsAreEqual(r101.permittedSubtreesDN, this.permittedSubtreesDN) == true) goto L20;
        return false;
    L20:
        if (collectionsAreEqual(r101.permittedSubtreesDNS, this.permittedSubtreesDNS) == true) goto L22;
        return false;
    L22:
        if (collectionsAreEqual(r101.permittedSubtreesEmail, this.permittedSubtreesEmail) == true) goto L24;
        return false;
    L24:
        if (collectionsAreEqual(r101.permittedSubtreesIP, this.permittedSubtreesIP) == true) goto L26;
        return false;
    L26:
        if (collectionsAreEqual(r101.permittedSubtreesURI, this.permittedSubtreesURI) == true) goto L28;
        return false;
    L28:
        if (collectionsAreEqual(r101.permittedSubtreesOtherName, this.permittedSubtreesOtherName) == false) goto L42;
        return true;
    L42:
        return false;
    }

    public int hashCode() {
        return ((((((((((hashCollection(this.excludedSubtreesDN) + hashCollection(this.excludedSubtreesDNS)) + hashCollection(this.excludedSubtreesEmail)) + hashCollection(this.excludedSubtreesIP)) + hashCollection(this.excludedSubtreesURI)) + hashCollection(this.excludedSubtreesOtherName)) + hashCollection(this.permittedSubtreesDN)) + hashCollection(this.permittedSubtreesDNS)) + hashCollection(this.permittedSubtreesEmail)) + hashCollection(this.permittedSubtreesIP)) + hashCollection(this.permittedSubtreesURI)) + hashCollection(this.permittedSubtreesOtherName);
    }

    @Override // org.bouncycastle.asn1.x509.NameConstraintValidator
    public void intersectEmptyPermittedSubtree(int r100) {
        if (r100 != 0) goto L4;
        this.permittedSubtreesOtherName = new HashSet();
        return;
    L4:
        if (r100 != 1) goto L6;
        this.permittedSubtreesEmail = new HashSet();
        return;
    L6:
        if (r100 != 2) goto L8;
        this.permittedSubtreesDNS = new HashSet();
        return;
    L8:
        if (r100 != 4) goto L10;
        this.permittedSubtreesDN = new HashSet();
        return;
    L10:
        if (r100 != 6) goto L12;
        this.permittedSubtreesURI = new HashSet();
        return;
    L12:
        if (r100 != 7) goto L15;
        this.permittedSubtreesIP = new HashSet();
        return;
    L15:
        throw new IllegalStateException("Unknown tag encountered: " + r100);
    }

    @Override // org.bouncycastle.asn1.x509.NameConstraintValidator
    public void intersectPermittedSubtree(GeneralSubtree r100) {
        intersectPermittedSubtree(new GeneralSubtree[]{r100});
    }

    @Override // org.bouncycastle.asn1.x509.NameConstraintValidator
    public void intersectPermittedSubtree(GeneralSubtree[] r100) {
        HashMap r101 = new HashMap();
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L9;
        GeneralSubtree r103 = r100[r102];
        Integer r104 = Integers.valueOf(r103.getBase().getTagNo());
        if (r101.get(r104) != null) goto L8;
        r101.put(r104, new HashSet());
    L8:
        ((Set) r101.get(r104)).add(r103);
        r102 = r102 + 1;
        goto L4
    L9:
        Iterator r105 = r101.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L32;
        Map.Entry r106 = (Map.Entry) r105.next();
        int r107 = ((Integer) r106.getKey()).intValue();
        if (r107 != 0) goto L15;
        this.permittedSubtreesOtherName = intersectOtherName(this.permittedSubtreesOtherName, (Set) r106.getValue());
        goto L11
    L15:
        if (r107 != 1) goto L17;
        this.permittedSubtreesEmail = intersectEmail(this.permittedSubtreesEmail, (Set) r106.getValue());
        goto L11
    L17:
        if (r107 != 2) goto L19;
        this.permittedSubtreesDNS = intersectDNS(this.permittedSubtreesDNS, (Set) r106.getValue());
        goto L11
    L19:
        if (r107 != 4) goto L21;
        this.permittedSubtreesDN = intersectDN(this.permittedSubtreesDN, (Set) r106.getValue());
        goto L11
    L21:
        if (r107 != 6) goto L23;
        this.permittedSubtreesURI = intersectURI(this.permittedSubtreesURI, (Set) r106.getValue());
        goto L11
    L23:
        if (r107 != 7) goto L26;
        this.permittedSubtreesIP = intersectIP(this.permittedSubtreesIP, (Set) r106.getValue());
        goto L11
    L26:
        throw new IllegalStateException("Unknown tag encountered: " + r107);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        addLine(r100, "permitted:");
        if (this.permittedSubtreesDN == null) goto L6;
        addLine(r100, "DN:");
        addLine(r100, this.permittedSubtreesDN.toString());
    L6:
        if (this.permittedSubtreesDNS == null) goto L9;
        addLine(r100, "DNS:");
        addLine(r100, this.permittedSubtreesDNS.toString());
    L9:
        if (this.permittedSubtreesEmail == null) goto L12;
        addLine(r100, "Email:");
        addLine(r100, this.permittedSubtreesEmail.toString());
    L12:
        if (this.permittedSubtreesURI == null) goto L15;
        addLine(r100, "URI:");
        addLine(r100, this.permittedSubtreesURI.toString());
    L15:
        if (this.permittedSubtreesIP == null) goto L18;
        addLine(r100, "IP:");
        addLine(r100, stringifyIPCollection(this.permittedSubtreesIP));
    L18:
        if (this.permittedSubtreesOtherName == null) goto L20;
        addLine(r100, "OtherName:");
        addLine(r100, stringifyOtherNameCollection(this.permittedSubtreesOtherName));
    L20:
        addLine(r100, "excluded:");
        if (this.excludedSubtreesDN.isEmpty() == true) goto L24;
        addLine(r100, "DN:");
        addLine(r100, this.excludedSubtreesDN.toString());
    L24:
        if (this.excludedSubtreesDNS.isEmpty() == true) goto L27;
        addLine(r100, "DNS:");
        addLine(r100, this.excludedSubtreesDNS.toString());
    L27:
        if (this.excludedSubtreesEmail.isEmpty() == true) goto L30;
        addLine(r100, "Email:");
        addLine(r100, this.excludedSubtreesEmail.toString());
    L30:
        if (this.excludedSubtreesURI.isEmpty() == true) goto L33;
        addLine(r100, "URI:");
        addLine(r100, this.excludedSubtreesURI.toString());
    L33:
        if (this.excludedSubtreesIP.isEmpty() == true) goto L36;
        addLine(r100, "IP:");
        addLine(r100, stringifyIPCollection(this.excludedSubtreesIP));
    L36:
        if (this.excludedSubtreesOtherName.isEmpty() == true) goto L39;
        addLine(r100, "OtherName:");
        addLine(r100, stringifyOtherNameCollection(this.excludedSubtreesOtherName));
    L39:
        return r100.toString();
    }
}
