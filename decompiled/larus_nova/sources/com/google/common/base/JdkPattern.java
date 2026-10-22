package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class JdkPattern extends e implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matcher f274700a;

        public a(Matcher r100) {
            r100.getClass();
            this.f274700a = r100;
        }
    }

    @Override // com.google.common.base.e
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.e
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.e
    public String toString() {
        return this.pattern.toString();
    }

    public JdkPattern(Pattern r100) {
        r100.getClass();
        this.pattern = r100;
    }

    @Override // com.google.common.base.e
    public d matcher(CharSequence r100) {
        return new a(this.pattern.matcher(r100));
    }
}
