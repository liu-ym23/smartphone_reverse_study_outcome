package com.ss.android.lark.message.card;

import android.text.TextUtils;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class CardMessageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431901a = 0;

    @Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/message/card/CardMessageUtils$RenderType;", "", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RenderType {
        public static final int CARD = 0;
        public static final int CARD_WITH_TRANSLATION = 2;
        public static final a Companion = null;
        public static final int TRANSLATION = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f431902a = null;

            static {
                f431902a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f431902a;
        }
    }

    public static final class a {
        public static boolean a(CardContent r100) {
            Intrinsics.checkNotNullParameter(r100, "cardContent");
            boolean r101 = b.a().getFgValue("messagecard.translate.force_enable_translate", false);
            if (r100.getExtraInfo() == null) goto L6;
            CardContent.ExtraInfo r102 = r100.getExtraInfo();
            Intrinsics.checkNotNull(r102);
            if (r102.getEnableTranslate() == false) goto L6;
        L9:
            if (r100.getType() == CardContent.Type.TEXT) goto L12;
            return false;
        L12:
            if (r100.getCardVersion() >= 2) goto L14;
            return false;
        L14:
            return true;
        L6:
            if (r101 == true) goto L9;
            return false;
        }

        public static boolean b(f r100) {
            Intrinsics.checkNotNullParameter(r100, "contentVO");
            if (r100.f411956f != 1) goto L6;
            return true;
        L6:
            if (r100.f411957g != null) goto L8;
            return true;
        L8:
            if (TextUtils.isEmpty(r100.f411952b) == true) goto L19;
            String r101 = r100.f411952b;
            f<T> r102 = r100.f411957g;
            if (r102 == 0) goto L12;
            String r103 = r102.f411952b;
        L14:
            if (Intrinsics.areEqual(r101, r103) == false) goto L20;
            return false;
        L20:
            return true;
        L12:
            r103 = null;
            goto L14
        L19:
            return true;
        }
    }

    static {
    }
}
