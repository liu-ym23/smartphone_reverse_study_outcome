package org.bouncycastle.asn1.eac;

import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes42.dex */
public class Flags {
    int value;

    public static class StringJoiner {
        boolean First;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        StringBuffer f525044b;
        String mSeparator;

        public StringJoiner(String r100) {
            this.First = true;
            this.f525044b = new StringBuffer();
            this.mSeparator = r100;
        }

        public void add(String r100) {
            if (this.First == false) goto L5;
            this.First = false;
        L6:
            this.f525044b.append(r100);
            return;
        L5:
            this.f525044b.append(this.mSeparator);
            goto L6
        }

        public String toString() {
            return this.f525044b.toString();
        }
    }

    public Flags() {
        this.value = 0;
    }

    public Flags(int r100) {
        this.value = r100;
    }

    public String decode(Hashtable r100) {
        StringJoiner r101 = new StringJoiner(" ");
        Enumeration r102 = r100.keys();
    L4:
        if (r102.hasMoreElements() == false) goto L9;
        Integer r103 = (Integer) r102.nextElement();
        if (isSet(r103.intValue()) == false) goto L4;
        r101.add((String) r100.get(r103));
        goto L4
    L9:
        return r101.toString();
    }

    public int getFlags() {
        return this.value;
    }

    public boolean isSet(int r100) {
        if ((r100 & this.value) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void set(int r100) {
        this.value = r100 | this.value;
    }
}
