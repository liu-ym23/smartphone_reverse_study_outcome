package com.google.common.hash;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
class Funnels$StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
    private final Charset charset;

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String charsetCanonicalName;

        private Object readResolve() {
            return new Funnels$StringCharsetFunnel(Charset.forName(this.charsetCanonicalName));
        }

        public SerializedForm(Charset r100) {
            this.charsetCanonicalName = r100.name();
        }
    }

    public int hashCode() {
        return Funnels$StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
    }

    public String toString() {
        return "Funnels.stringFunnel(" + this.charset.name() + ")";
    }

    public Object writeReplace() {
        return new SerializedForm(this.charset);
    }

    public Funnels$StringCharsetFunnel(Charset r100) {
        r100.getClass();
        this.charset = r100;
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Funnels$StringCharsetFunnel) == true) goto L5;
        return false;
    L5:
        return this.charset.equals(((Funnels$StringCharsetFunnel) r100).charset);
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(CharSequence r100, k r101) {
        r101.e(r100, this.charset);
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(CharSequence r100, k r101) {
        funnel2(r100, r101);
    }
}
