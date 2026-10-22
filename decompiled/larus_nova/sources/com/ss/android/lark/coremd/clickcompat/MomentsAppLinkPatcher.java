package com.ss.android.lark.coremd.clickcompat;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z5c.k3;

/* JADX INFO: loaded from: classes35.dex */
public final class MomentsAppLinkPatcher {

    @Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/coremd/clickcompat/MomentsAppLinkPatcher$PatchScene;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PatchScene {
        public static final int CARD_MSG = 1;
        public static final a Companion = null;
        public static final int IM_MSG = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f419601a = null;

            static {
                f419601a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f419601a;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(String r100) {
        if (r100 == null) goto L37;
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L7;
        return r100;
    L7:
        if (StringsKt.contains$default(r100, "/client/moments/home", false, 2, null) == false) goto L9;
    L16:
        String r102 = k3.f570238f.f540772b;
        Uri.Builder r103 = r101.buildUpon();
        if (UriProtector.getQueryParameter(r101, "from") == null) goto L28;
        if (r102 == null) goto L28;
        r103.clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r101).iterator();
    L21:
        if (r104.hasNext() == false) goto L28;
        String r105 = r104.next();
        if (Intrinsics.areEqual(r105, "from") == true) goto L21;
        Iterator<String> r106 = UriProtector.getQueryParameters(r101, r105).iterator();
    L26:
        if (r106.hasNext() == false) goto L21;
        r103.appendQueryParameter(r105, r106.next());
    L28:
        if (r102 == null) goto L31;
        r103.appendQueryParameter("from", r102);
    L31:
        return r103.build().toString();
    L9:
        if (StringsKt.contains$default(r100, "/client/moments/detail", false, 2, null) == true) goto L16;
        if (StringsKt.contains$default(r100, "/client/moments/category", false, 2, null) == true) goto L16;
        if (StringsKt.contains$default(r100, "/client/moments/hashtag", false, 2, null) == true) goto L16;
        return r100;
    L37:
        return r100;
    }
}
