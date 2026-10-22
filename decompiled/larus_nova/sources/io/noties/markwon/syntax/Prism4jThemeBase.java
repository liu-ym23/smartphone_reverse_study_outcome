package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.facebook.keyframes.model.KFAnimation;
import etc.d;
import gtc.g;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Prism4jThemeBase implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorHashMap f492658a;

    public static class ColorHashMap extends HashMap<String, a> {
        public ColorHashMap() {
        }

        public ColorHashMap add(int r100, String... r101) {
            a r102 = new a(r100);
            int r103 = r101.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L5;
            put(r101[r104], r102);
            r104 = r104 + 1;
            goto L3
        L5:
            return this;
        }

        public ColorHashMap add(int r100, String r101) {
            put(r101, new a(r100));
            return this;
        }

        public ColorHashMap add(int r100, String r101, String r102) {
            a r103 = new a(r100);
            put(r101, r103);
            put(r102, r103);
            return this;
        }

        public ColorHashMap add(int r100, String r101, String r102, String r103) {
            a r104 = new a(r100);
            put(r101, r104);
            put(r102, r104);
            put(r103, r104);
            return this;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f492659a;

        public a(int r100) {
            this.f492659a = r100;
        }
    }

    public abstract void d(String r100, String r101, String r102, int r103, SpannableStringBuilder r104, int r105, int r106);

    public Prism4jThemeBase() {
        this.f492658a = new ColorHashMap().add(-9404272, new String[]{"comment", "prolog", "doctype", "cdata"}).add(-6710887, "punctuation").add(-6750123, new String[]{KFAnimation.PROPERTY_TYPE_JSON_FIELD, "tag", "boolean", "number", "constant", "symbol", "deleted"}).add(-10053376, new String[]{"selector", "attr-name", "string", "char", "builtin", "inserted"}).add(-6656454, OnekeyLoginConstants.CU_KEY_OPERATOR, "entity", "url").add(-16746582, "atrule", "attr-value", "keyword").add(-2274712, "function", "class-name").add(-1140480, "regex", "important", "variable");
    }

    public static boolean e(String r100, String r101, String r102) {
        if (r100.equals(r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.equals(r102) == true) goto L8;
        return false;
    }

    @Override // etc.d
    public final void b(String r100, g.d r110, SpannableStringBuilder r111, int r112, int r113) {
        String r101 = r110.type();
        String r102 = r110.alias();
        a r114 = this.f492658a.get(r101);
        if (r114 != null) goto L6;
        if (r102 == null) goto L6;
        r114 = this.f492658a.get(r102);
    L6:
        if (r114 == null) goto L8;
        int r103 = r114.f492659a;
    L9:
        if (r103 == 0) goto L12;
        d(r100, r101, r102, r103, r111, r112, r113);
        return;
    L12:
        return;
    L8:
        r103 = 0;
        goto L9
    }
}
