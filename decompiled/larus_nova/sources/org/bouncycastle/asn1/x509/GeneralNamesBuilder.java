package org.bouncycastle.asn1.x509;

import java.util.Vector;

/* JADX INFO: loaded from: classes42.dex */
public class GeneralNamesBuilder {
    private Vector names;

    public GeneralNamesBuilder() {
        this.names = new Vector();
    }

    public GeneralNamesBuilder addName(GeneralName r100) {
        this.names.addElement(r100);
        return this;
    }

    public GeneralNamesBuilder addNames(GeneralNames r100) {
        GeneralName[] r101 = r100.getNames();
        int r102 = 0;
    L4:
        if (r102 == r101.length) goto L6;
        this.names.addElement(r101[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return this;
    }

    public GeneralNames build() {
        int r100 = this.names.size();
        GeneralName[] r101 = new GeneralName[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L6;
        r101[r102] = (GeneralName) this.names.elementAt(r102);
        r102 = r102 + 1;
        goto L3
    L6:
        return new GeneralNames(r101);
    }
}
