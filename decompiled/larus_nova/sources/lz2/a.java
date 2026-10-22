package lz2;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes12.dex */
public class a implements Comparable<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f511341d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f511342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Regex f511343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C6752a f511344c;

    /* JADX INFO: renamed from: lz2.a$a, reason: collision with other inner class name */
    public final class C6752a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f511345a;

        public C6752a(a r100) {
            this.f511345a = r100;
        }
    }

    static {
        f511341d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "regex", "getRegex()Lkotlin/text/Regex;", 0))};
    }

    public final Regex b() {
        C6752a r100 = this.f511344c;
        KProperty<Object> r101 = f511341d[0];
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return r100.f511345a.c();
    }

    public Regex c() {
        Regex r100 = this.f511343b;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("_regex");
        return null;
    L7:
        return r100;
    }

    public String toString() {
        return this.f511342a + ": [" + b() + ']';
    }

    public int a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return r100.b().getPattern().length() - b().getPattern().length();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a r100) {
        return a(r100);
    }

    public a(String r100, Regex r101) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f511342a = r100;
        this.f511344c = new C6752a(this);
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f511343b = r101;
        return;
    }
}
