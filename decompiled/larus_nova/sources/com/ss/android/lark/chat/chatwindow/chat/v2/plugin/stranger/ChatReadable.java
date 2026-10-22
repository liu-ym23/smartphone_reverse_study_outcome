package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/ChatReadable;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ChatReadable {
    public static final a Companion = null;
    public static final int READABLE = 1;
    public static final int UNKNOWN = 0;
    public static final int UNREADABLE = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f414479a = null;

        static {
            f414479a = new a();
        }

        public a() {
        }

        public static int a(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Integer r101 = r100.getChatterExtraStates().get(5);
            if (r101 != null) goto L7;
            return 0;
        L7:
            return r101.intValue();
        }
    }

    static {
        Companion = a.f414479a;
    }
}
