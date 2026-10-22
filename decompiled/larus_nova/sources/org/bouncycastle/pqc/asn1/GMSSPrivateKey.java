package org.bouncycastle.pqc.asn1;

import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.crypto.gmss.GMSSLeaf;
import org.bouncycastle.pqc.crypto.gmss.GMSSParameters;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootSig;
import org.bouncycastle.pqc.crypto.gmss.Treehash;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSPrivateKey extends ASN1Object {
    private ASN1Primitive primitive;

    private GMSSPrivateKey(ASN1Sequence r110) {
        ASN1Sequence r100 = (ASN1Sequence) r110.getObjectAt(0);
        int[] r101 = new int[r100.size()];
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101[r102] = checkBigIntegerInIntRange(r100.getObjectAt(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        ASN1Sequence r103 = (ASN1Sequence) r110.getObjectAt(1);
        int r104 = r103.size();
        byte[][] r105 = new byte[r104][];
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L9;
        r105[r106] = ((DEROctetString) r103.getObjectAt(r106)).getOctets();
        r106 = r106 + 1;
        goto L7
    L9:
        ASN1Sequence r107 = (ASN1Sequence) r110.getObjectAt(2);
        int r108 = r107.size();
        byte[][] r109 = new byte[r108][];
        int r111 = 0;
    L10:
        if (r111 >= r108) goto L12;
        r109[r111] = ((DEROctetString) r107.getObjectAt(r111)).getOctets();
        r111 = r111 + 1;
        goto L10
    L12:
        ASN1Sequence r112 = (ASN1Sequence) r110.getObjectAt(3);
        int r113 = r112.size();
        byte[][][] r114 = new byte[r113][][];
        int r115 = 0;
    L13:
        if (r115 >= r113) goto L19;
        ASN1Sequence r116 = (ASN1Sequence) r112.getObjectAt(r115);
        r114[r115] = new byte[r116.size()][];
        int r117 = 0;
    L15:
        byte[][] r118 = r114[r115];
        if (r117 >= r118.length) goto L18;
        r118[r117] = ((DEROctetString) r116.getObjectAt(r117)).getOctets();
        r117 = r117 + 1;
        goto L15
    L18:
        r115 = r115 + 1;
        goto L13
    L19:
        ASN1Sequence r119 = (ASN1Sequence) r110.getObjectAt(4);
        int r120 = r119.size();
        byte[][][] r121 = new byte[r120][][];
        int r122 = 0;
    L20:
        if (r122 >= r120) goto L26;
        ASN1Sequence r123 = (ASN1Sequence) r119.getObjectAt(r122);
        r121[r122] = new byte[r123.size()][];
        int r124 = 0;
    L22:
        byte[][] r125 = r121[r122];
        if (r124 >= r125.length) goto L25;
        r125[r124] = ((DEROctetString) r123.getObjectAt(r124)).getOctets();
        r124 = r124 + 1;
        goto L22
    L25:
        r122 = r122 + 1;
        goto L20
    L26:
        Treehash[][] r126 = new Treehash[((ASN1Sequence) r110.getObjectAt(5)).size()][];
    }

    public GMSSPrivateKey(int[] r210, byte[][] r211, byte[][] r212, byte[][][] r213, byte[][][] r310, Treehash[][] r311, Treehash[][] r312, Vector[] r313, Vector[] r314, Vector[][] r315, Vector[][] r316, byte[][][] r317, GMSSLeaf[] r318, GMSSLeaf[] r319, GMSSLeaf[] r410, int[] r411, byte[][] r412, GMSSRootCalc[] r413, byte[][] r414, GMSSRootSig[] r415, GMSSParameters r416, AlgorithmIdentifier r417) {
        this.primitive = encode(r210, r211, r212, r213, r310, r317, r311, r312, r313, r314, r315, r316, r318, r319, r410, r411, r412, r413, r414, r415, r416, new AlgorithmIdentifier[]{r417});
    }

    private static int checkBigIntegerInIntRange(ASN1Encodable r100) {
        return ((ASN1Integer) r100).intValueExact();
    }

    private ASN1Primitive encode(int[] r210, byte[][] r211, byte[][] r212, byte[][][] r213, byte[][][] r214, byte[][][] r215, Treehash[][] r216, Treehash[][] r217, Vector[] r310, Vector[] r311, Vector[][] r312, Vector[][] r313, GMSSLeaf[] r314, GMSSLeaf[] r315, GMSSLeaf[] r316, int[] r317, byte[][] r318, GMSSRootCalc[] r319, byte[][] r410, GMSSRootSig[] r411, GMSSParameters r412, AlgorithmIdentifier[] r413) {
        ASN1EncodableVector r110 = new ASN1EncodableVector();
        ASN1EncodableVector r111 = new ASN1EncodableVector();
        int r112 = 0;
    L4:
        if (r112 >= r210.length) goto L6;
        r111.add(new ASN1Integer(r210[r112]));
        r112 = r112 + 1;
        goto L4
    L6:
        r110.add(new DERSequence(r111));
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        int r101 = 0;
    L8:
        if (r101 >= r211.length) goto L10;
        r100.add(new DEROctetString(r211[r101]));
        r101 = r101 + 1;
        goto L8
    L10:
        r110.add(new DERSequence(r100));
        ASN1EncodableVector r102 = new ASN1EncodableVector();
        int r103 = 0;
    L12:
        if (r103 >= r212.length) goto L14;
        r102.add(new DEROctetString(r212[r103]));
        r103 = r103 + 1;
        goto L12
    L14:
        r110.add(new DERSequence(r102));
        ASN1EncodableVector r104 = new ASN1EncodableVector();
        ASN1EncodableVector r105 = new ASN1EncodableVector();
        int r106 = 0;
    L16:
        if (r106 >= r213.length) goto L22;
        int r107 = 0;
    L18:
        byte[][] r113 = r213[r106];
        if (r107 >= r113.length) goto L21;
        r104.add(new DEROctetString(r113[r107]));
        r107 = r107 + 1;
        goto L18
    L21:
        r105.add(new DERSequence(r104));
        r104 = new ASN1EncodableVector();
        r106 = r106 + 1;
        goto L16
    L22:
        r110.add(new DERSequence(r105));
        ASN1EncodableVector r108 = new ASN1EncodableVector();
        ASN1EncodableVector r109 = new ASN1EncodableVector();
        int r114 = 0;
    L24:
        if (r114 >= r214.length) goto L30;
        int r115 = 0;
    L26:
        byte[][] r116 = r214[r114];
        if (r115 >= r116.length) goto L29;
        r108.add(new DEROctetString(r116[r115]));
        r115 = r115 + 1;
        goto L26
    L29:
        r109.add(new DERSequence(r108));
        r108 = new ASN1EncodableVector();
        r114 = r114 + 1;
        goto L24
    L30:
        r110.add(new DERSequence(r109));
        ASN1EncodableVector r117 = new ASN1EncodableVector();
        ASN1EncodableVector r118 = new ASN1EncodableVector();
        ASN1EncodableVector r119 = new ASN1EncodableVector();
        ASN1EncodableVector r120 = new ASN1EncodableVector();
        ASN1EncodableVector r121 = new ASN1EncodableVector();
        int r122 = 0;
    L32:
        if (r122 >= r216.length) goto L44;
        int r123 = 0;
    L35:
        if (r123 >= r216[r122].length) goto L43;
        r119.add(new DERSequence(r413[0]));
        int r124 = r216[r122][r123].getStatInt()[1];
        r120.add(new DEROctetString(r216[r122][r123].getStatByte()[0]));
        r120.add(new DEROctetString(r216[r122][r123].getStatByte()[1]));
        r120.add(new DEROctetString(r216[r122][r123].getStatByte()[2]));
        int r125 = 0;
    L37:
        if (r125 >= r124) goto L39;
        r120.add(new DEROctetString(r216[r122][r123].getStatByte()[r125 + 3]));
        r125 = r125 + 1;
        goto L37
    L39:
        r119.add(new DERSequence(r120));
        r120 = new ASN1EncodableVector();
        r121.add(new ASN1Integer(r216[r122][r123].getStatInt()[0]));
        r121.add(new ASN1Integer(r124));
        r121.add(new ASN1Integer(r216[r122][r123].getStatInt()[2]));
        r121.add(new ASN1Integer(r216[r122][r123].getStatInt()[3]));
        r121.add(new ASN1Integer(r216[r122][r123].getStatInt()[4]));
        r121.add(new ASN1Integer(r216[r122][r123].getStatInt()[5]));
        int r126 = 0;
    L40:
        if (r126 >= r124) goto L42;
        r121.add(new ASN1Integer(r216[r122][r123].getStatInt()[r126 + 6]));
        r126 = r126 + 1;
        r216 = r216;
        goto L40
    L42:
        r119.add(new DERSequence(r121));
        r121 = new ASN1EncodableVector();
        r118.add(new DERSequence(r119));
        r119 = new ASN1EncodableVector();
        r123 = r123 + 1;
        r216 = r216;
        goto L35
    L43:
        r117.add(new DERSequence(r118));
        r118 = new ASN1EncodableVector();
        r122 = r122 + 1;
        goto L32
    L44:
        r110.add(new DERSequence(r117));
        ASN1EncodableVector r127 = new ASN1EncodableVector();
        ASN1EncodableVector r128 = new ASN1EncodableVector();
        ASN1EncodableVector r129 = new ASN1EncodableVector();
        ASN1EncodableVector r130 = new ASN1EncodableVector();
        ASN1EncodableVector r131 = new ASN1EncodableVector();
        int r132 = 0;
    L46:
        if (r132 >= r217.length) goto L58;
        int r133 = 0;
    L49:
        if (r133 >= r217[r132].length) goto L57;
        r129.add(new DERSequence(r413[0]));
        int r134 = r217[r132][r133].getStatInt()[1];
        r130.add(new DEROctetString(r217[r132][r133].getStatByte()[0]));
        r130.add(new DEROctetString(r217[r132][r133].getStatByte()[1]));
        r130.add(new DEROctetString(r217[r132][r133].getStatByte()[2]));
        int r135 = 0;
    L51:
        if (r135 >= r134) goto L53;
        r130.add(new DEROctetString(r217[r132][r133].getStatByte()[r135 + 3]));
        r135 = r135 + 1;
        goto L51
    L53:
        r129.add(new DERSequence(r130));
        r130 = new ASN1EncodableVector();
        r131.add(new ASN1Integer(r217[r132][r133].getStatInt()[0]));
        r131.add(new ASN1Integer(r134));
        r131.add(new ASN1Integer(r217[r132][r133].getStatInt()[2]));
        r131.add(new ASN1Integer(r217[r132][r133].getStatInt()[3]));
        r131.add(new ASN1Integer(r217[r132][r133].getStatInt()[4]));
        r131.add(new ASN1Integer(r217[r132][r133].getStatInt()[5]));
        int r136 = 0;
    L54:
        if (r136 >= r134) goto L56;
        r131.add(new ASN1Integer(r217[r132][r133].getStatInt()[r136 + 6]));
        r136 = r136 + 1;
        goto L54
    L56:
        r129.add(new DERSequence(r131));
        r131 = new ASN1EncodableVector();
        r128.add(new DERSequence(r129));
        r129 = new ASN1EncodableVector();
        r133 = r133 + 1;
        goto L49
    L57:
        r127.add(new DERSequence(new DERSequence(r128)));
        r128 = new ASN1EncodableVector();
        r132 = r132 + 1;
        goto L46
    L58:
        r110.add(new DERSequence(r127));
        ASN1EncodableVector r137 = new ASN1EncodableVector();
        ASN1EncodableVector r138 = new ASN1EncodableVector();
        int r139 = 0;
    L60:
        if (r139 >= r215.length) goto L66;
        int r140 = 0;
    L62:
        byte[][] r141 = r215[r139];
        if (r140 >= r141.length) goto L65;
        r137.add(new DEROctetString(r141[r140]));
        r140 = r140 + 1;
        goto L62
    L65:
        r138.add(new DERSequence(r137));
        r137 = new ASN1EncodableVector();
        r139 = r139 + 1;
        goto L60
    L66:
        r110.add(new DERSequence(r138));
        ASN1EncodableVector r142 = new ASN1EncodableVector();
        ASN1EncodableVector r143 = new ASN1EncodableVector();
        int r144 = 0;
    L68:
        if (r144 >= r310.length) goto L74;
        int r145 = 0;
    L71:
        if (r145 >= r310[r144].size()) goto L73;
        r142.add(new DEROctetString((byte[]) r310[r144].elementAt(r145)));
        r145 = r145 + 1;
        goto L71
    L73:
        r143.add(new DERSequence(r142));
        r142 = new ASN1EncodableVector();
        r144 = r144 + 1;
        goto L68
    L74:
        r110.add(new DERSequence(r143));
        ASN1EncodableVector r146 = new ASN1EncodableVector();
        ASN1EncodableVector r147 = new ASN1EncodableVector();
        int r148 = 0;
    L76:
        if (r148 >= r311.length) goto L82;
        int r149 = 0;
    L79:
        if (r149 >= r311[r148].size()) goto L81;
        r146.add(new DEROctetString((byte[]) r311[r148].elementAt(r149)));
        r149 = r149 + 1;
        goto L79
    L81:
        r147.add(new DERSequence(r146));
        r146 = new ASN1EncodableVector();
        r148 = r148 + 1;
        goto L76
    L82:
        r110.add(new DERSequence(r147));
        ASN1EncodableVector r150 = new ASN1EncodableVector();
        ASN1EncodableVector r151 = new ASN1EncodableVector();
        ASN1EncodableVector r152 = new ASN1EncodableVector();
        int r153 = 0;
    L84:
        if (r153 >= r312.length) goto L94;
        int r154 = 0;
    L87:
        if (r154 >= r312[r153].length) goto L93;
        int r155 = 0;
    L90:
        if (r155 >= r312[r153][r154].size()) goto L92;
        r150.add(new DEROctetString((byte[]) r312[r153][r154].elementAt(r155)));
        r155 = r155 + 1;
        goto L90
    L92:
        r151.add(new DERSequence(r150));
        r150 = new ASN1EncodableVector();
        r154 = r154 + 1;
        goto L87
    L93:
        r152.add(new DERSequence(r151));
        r151 = new ASN1EncodableVector();
        r153 = r153 + 1;
        goto L84
    L94:
        r110.add(new DERSequence(r152));
        ASN1EncodableVector r156 = new ASN1EncodableVector();
        ASN1EncodableVector r157 = new ASN1EncodableVector();
        ASN1EncodableVector r158 = new ASN1EncodableVector();
        int r159 = 0;
    L96:
        if (r159 >= r313.length) goto L106;
        int r160 = 0;
    L99:
        if (r160 >= r313[r159].length) goto L105;
        int r161 = 0;
    L102:
        if (r161 >= r313[r159][r160].size()) goto L104;
        r156.add(new DEROctetString((byte[]) r313[r159][r160].elementAt(r161)));
        r161 = r161 + 1;
        goto L102
    L104:
        r157.add(new DERSequence(r156));
        r156 = new ASN1EncodableVector();
        r160 = r160 + 1;
        goto L99
    L105:
        r158.add(new DERSequence(r157));
        r157 = new ASN1EncodableVector();
        r159 = r159 + 1;
        goto L96
    L106:
        r110.add(new DERSequence(r158));
        ASN1EncodableVector r162 = new ASN1EncodableVector();
        ASN1EncodableVector r163 = new ASN1EncodableVector();
        ASN1EncodableVector r164 = new ASN1EncodableVector();
        ASN1EncodableVector r165 = new ASN1EncodableVector();
        int r166 = 0;
    L108:
        if (r166 >= r314.length) goto L110;
        r163.add(new DERSequence(r413[0]));
        byte[][] r167 = r314[r166].getStatByte();
        r164.add(new DEROctetString(r167[0]));
        r164.add(new DEROctetString(r167[1]));
        r164.add(new DEROctetString(r167[2]));
        r164.add(new DEROctetString(r167[3]));
        r163.add(new DERSequence(r164));
        r164 = new ASN1EncodableVector();
        int[] r168 = r314[r166].getStatInt();
        r165.add(new ASN1Integer(r168[0]));
        r165.add(new ASN1Integer(r168[1]));
        r165.add(new ASN1Integer(r168[2]));
        r165.add(new ASN1Integer(r168[3]));
        r163.add(new DERSequence(r165));
        r165 = new ASN1EncodableVector();
        r162.add(new DERSequence(r163));
        r163 = new ASN1EncodableVector();
        r166 = r166 + 1;
        goto L108
    L110:
        r110.add(new DERSequence(r162));
        ASN1EncodableVector r169 = new ASN1EncodableVector();
        ASN1EncodableVector r170 = new ASN1EncodableVector();
        ASN1EncodableVector r171 = new ASN1EncodableVector();
        ASN1EncodableVector r172 = new ASN1EncodableVector();
        int r173 = 0;
    L112:
        if (r173 >= r315.length) goto L114;
        r170.add(new DERSequence(r413[0]));
        byte[][] r174 = r315[r173].getStatByte();
        r171.add(new DEROctetString(r174[0]));
        r171.add(new DEROctetString(r174[1]));
        r171.add(new DEROctetString(r174[2]));
        r171.add(new DEROctetString(r174[3]));
        r170.add(new DERSequence(r171));
        r171 = new ASN1EncodableVector();
        int[] r175 = r315[r173].getStatInt();
        r172.add(new ASN1Integer(r175[0]));
        r172.add(new ASN1Integer(r175[1]));
        r172.add(new ASN1Integer(r175[2]));
        r172.add(new ASN1Integer(r175[3]));
        r170.add(new DERSequence(r172));
        r172 = new ASN1EncodableVector();
        r169.add(new DERSequence(r170));
        r170 = new ASN1EncodableVector();
        r173 = r173 + 1;
        goto L112
    L114:
        r110.add(new DERSequence(r169));
        ASN1EncodableVector r176 = new ASN1EncodableVector();
        ASN1EncodableVector r177 = new ASN1EncodableVector();
        ASN1EncodableVector r178 = new ASN1EncodableVector();
        ASN1EncodableVector r179 = new ASN1EncodableVector();
        ASN1EncodableVector r180 = r110;
        int r181 = 0;
    L116:
        if (r181 >= r316.length) goto L118;
        r177.add(new DERSequence(r413[0]));
        byte[][] r182 = r316[r181].getStatByte();
        r178.add(new DEROctetString(r182[0]));
        r178.add(new DEROctetString(r182[1]));
        r178.add(new DEROctetString(r182[2]));
        r178.add(new DEROctetString(r182[3]));
        r177.add(new DERSequence(r178));
        r178 = new ASN1EncodableVector();
        int[] r183 = r316[r181].getStatInt();
        r179.add(new ASN1Integer(r183[0]));
        r179.add(new ASN1Integer(r183[1]));
        r179.add(new ASN1Integer(r183[2]));
        r179.add(new ASN1Integer(r183[3]));
        r177.add(new DERSequence(r179));
        r179 = new ASN1EncodableVector();
        r176.add(new DERSequence(r177));
        r177 = new ASN1EncodableVector();
        r181 = r181 + 1;
        goto L116
    L118:
        r180.add(new DERSequence(r176));
        ASN1EncodableVector r184 = new ASN1EncodableVector();
        int r185 = 0;
    L120:
        if (r185 >= r317.length) goto L122;
        r184.add(new ASN1Integer(r317[r185]));
        r185 = r185 + 1;
        goto L120
    L122:
        r180.add(new DERSequence(r184));
        ASN1EncodableVector r186 = new ASN1EncodableVector();
        int r187 = 0;
    L124:
        if (r187 >= r318.length) goto L126;
        r186.add(new DEROctetString(r318[r187]));
        r187 = r187 + 1;
        goto L124
    L126:
        r180.add(new DERSequence(r186));
        ASN1EncodableVector r188 = new ASN1EncodableVector();
        ASN1EncodableVector r189 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector r190 = new ASN1EncodableVector();
        ASN1EncodableVector r191 = new ASN1EncodableVector();
        ASN1EncodableVector r192 = new ASN1EncodableVector();
        ASN1EncodableVector r193 = new ASN1EncodableVector();
        int r194 = 0;
    L128:
        if (r194 >= r319.length) goto L164;
        r189.add(new DERSequence(r413[0]));
        new ASN1EncodableVector();
        int r195 = r319[r194].getStatInt()[0];
        int r196 = r319[r194].getStatInt()[7];
        r190.add(new DEROctetString(r319[r194].getStatByte()[0]));
        int r197 = 0;
    L130:
        if (r197 >= r195) goto L132;
        r197 = r197 + 1;
        r190.add(new DEROctetString(r319[r194].getStatByte()[r197]));
        goto L130
    L132:
        int r198 = 0;
    L133:
        if (r198 >= r196) goto L135;
        r190.add(new DEROctetString(r319[r194].getStatByte()[(r195 + 1) + r198]));
        r198 = r198 + 1;
        goto L133
    L135:
        r189.add(new DERSequence(r190));
        ASN1EncodableVector r199 = new ASN1EncodableVector();
        r191.add(new ASN1Integer(r195));
        r191.add(new ASN1Integer(r319[r194].getStatInt()[1]));
        r191.add(new ASN1Integer(r319[r194].getStatInt()[2]));
        r191.add(new ASN1Integer(r319[r194].getStatInt()[3]));
        r191.add(new ASN1Integer(r319[r194].getStatInt()[4]));
        r191.add(new ASN1Integer(r319[r194].getStatInt()[5]));
        r191.add(new ASN1Integer(r319[r194].getStatInt()[6]));
        r191.add(new ASN1Integer(r196));
        int r1100 = 0;
    L136:
        if (r1100 >= r195) goto L138;
        r191.add(new ASN1Integer(r319[r194].getStatInt()[r1100 + 8]));
        r1100 = r1100 + 1;
        goto L136
    L138:
        int r1101 = 0;
    L139:
        if (r1101 >= r196) goto L141;
        r191.add(new ASN1Integer(r319[r194].getStatInt()[(r195 + 8) + r1101]));
        r1101 = r1101 + 1;
        goto L139
    L141:
        r189.add(new DERSequence(r191));
        ASN1EncodableVector r200 = new ASN1EncodableVector();
        ASN1EncodableVector r1102 = new ASN1EncodableVector();
        ASN1EncodableVector r1103 = new ASN1EncodableVector();
        ASN1EncodableVector r1104 = new ASN1EncodableVector();
        if (r319[r194].getTreehash() == null) goto L153;
        int r1105 = 0;
    L145:
        if (r1105 >= r319[r194].getTreehash().length) goto L153;
        r1102.add(new DERSequence(r413[0]));
        int r1106 = r319[r194].getTreehash()[r1105].getStatInt()[1];
        ASN1EncodableVector r218 = r199;
        r1103.add(new DEROctetString(r319[r194].getTreehash()[r1105].getStatByte()[0]));
        r1103.add(new DEROctetString(r319[r194].getTreehash()[r1105].getStatByte()[1]));
        r1103.add(new DEROctetString(r319[r194].getTreehash()[r1105].getStatByte()[2]));
        int r201 = 0;
    L147:
        if (r201 >= r1106) goto L149;
        r1103.add(new DEROctetString(r319[r194].getTreehash()[r1105].getStatByte()[r201 + 3]));
        r201 = r201 + 1;
        r200 = r200;
        goto L147
    L149:
        ASN1EncodableVector r219 = r200;
        r1102.add(new DERSequence(r1103));
        r1103 = new ASN1EncodableVector();
        ASN1EncodableVector r1107 = r180;
        r1104.add(new ASN1Integer(r319[r194].getTreehash()[r1105].getStatInt()[0]));
        r1104.add(new ASN1Integer(r1106));
        r1104.add(new ASN1Integer(r319[r194].getTreehash()[r1105].getStatInt()[2]));
        r1104.add(new ASN1Integer(r319[r194].getTreehash()[r1105].getStatInt()[3]));
        r1104.add(new ASN1Integer(r319[r194].getTreehash()[r1105].getStatInt()[4]));
        r1104.add(new ASN1Integer(r319[r194].getTreehash()[r1105].getStatInt()[5]));
        int r202 = 0;
    L150:
        if (r202 >= r1106) goto L152;
        r1104.add(new ASN1Integer(r319[r194].getTreehash()[r1105].getStatInt()[r202 + 6]));
        r202 = r202 + 1;
        r1106 = r1106;
        r1107 = r1107;
        goto L150
    L152:
        r1102.add(new DERSequence(r1104));
        r1104 = new ASN1EncodableVector();
        r192.add(new DERSequence(r1102));
        r1102 = new ASN1EncodableVector();
        r1105 = r1105 + 1;
        r199 = r218;
        r200 = r219;
        r180 = r1107;
    L153:
        ASN1EncodableVector r220 = r199;
        ASN1EncodableVector r221 = r200;
        ASN1EncodableVector r222 = r180;
        r189.add(new DERSequence(r192));
        r192 = new ASN1EncodableVector();
        ASN1EncodableVector r203 = new ASN1EncodableVector();
        if (r319[r194].getRetain() == null) goto L163;
        int r204 = 0;
    L157:
        if (r204 >= r319[r194].getRetain().length) goto L163;
        int r205 = 0;
    L160:
        if (r205 >= r319[r194].getRetain()[r204].size()) goto L162;
        r203.add(new DEROctetString((byte[]) r319[r194].getRetain()[r204].elementAt(r205)));
        r205 = r205 + 1;
        goto L160
    L162:
        r193.add(new DERSequence(r203));
        r203 = new ASN1EncodableVector();
        r204 = r204 + 1;
    L163:
        r189.add(new DERSequence(r193));
        r193 = new ASN1EncodableVector();
        r188.add(new DERSequence(r189));
        r189 = new ASN1EncodableVector();
        r194 = r194 + 1;
        r190 = r220;
        r191 = r221;
        r180 = r222;
        goto L128
    L164:
        ASN1EncodableVector r223 = r180;
        r223.add(new DERSequence(r188));
        ASN1EncodableVector r206 = new ASN1EncodableVector();
        int r207 = 0;
    L166:
        if (r207 >= r410.length) goto L168;
        r206.add(new DEROctetString(r410[r207]));
        r207 = r207 + 1;
        goto L166
    L168:
        r223.add(new DERSequence(r206));
        ASN1EncodableVector r208 = new ASN1EncodableVector();
        ASN1EncodableVector r209 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector r224 = new ASN1EncodableVector();
        ASN1EncodableVector r225 = new ASN1EncodableVector();
        int r226 = 0;
    L170:
        if (r226 >= r411.length) goto L172;
        r209.add(new DERSequence(r413[0]));
        new ASN1EncodableVector();
        r224.add(new DEROctetString(r411[r226].getStatByte()[0]));
        r224.add(new DEROctetString(r411[r226].getStatByte()[1]));
        r224.add(new DEROctetString(r411[r226].getStatByte()[2]));
        r224.add(new DEROctetString(r411[r226].getStatByte()[3]));
        r224.add(new DEROctetString(r411[r226].getStatByte()[4]));
        r209.add(new DERSequence(r224));
        r224 = new ASN1EncodableVector();
        r225.add(new ASN1Integer(r411[r226].getStatInt()[0]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[1]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[2]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[3]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[4]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[5]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[6]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[7]));
        r225.add(new ASN1Integer(r411[r226].getStatInt()[8]));
        r209.add(new DERSequence(r225));
        r225 = new ASN1EncodableVector();
        r208.add(new DERSequence(r209));
        r209 = new ASN1EncodableVector();
        r226 = r226 + 1;
        goto L170
    L172:
        r223.add(new DERSequence(r208));
        ASN1EncodableVector r227 = new ASN1EncodableVector();
        ASN1EncodableVector r228 = new ASN1EncodableVector();
        ASN1EncodableVector r229 = new ASN1EncodableVector();
        ASN1EncodableVector r230 = new ASN1EncodableVector();
        int r231 = 0;
    L174:
        if (r231 >= r412.getHeightOfTrees().length) goto L176;
        r228.add(new ASN1Integer(r412.getHeightOfTrees()[r231]));
        r229.add(new ASN1Integer(r412.getWinternitzParameter()[r231]));
        r230.add(new ASN1Integer(r412.getK()[r231]));
        r231 = r231 + 1;
        goto L174
    L176:
        r227.add(new ASN1Integer(r412.getNumOfLayers()));
        r227.add(new DERSequence(r228));
        r227.add(new DERSequence(r229));
        r227.add(new DERSequence(r230));
        r223.add(new DERSequence(r227));
        ASN1EncodableVector r232 = new ASN1EncodableVector();
        int r233 = 0;
    L178:
        if (r233 >= r413.length) goto L180;
        r232.add(r413[r233]);
        r233 = r233 + 1;
        goto L178
    L180:
        r223.add(new DERSequence(r232));
        return new DERSequence(r223);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.primitive;
    }
}
