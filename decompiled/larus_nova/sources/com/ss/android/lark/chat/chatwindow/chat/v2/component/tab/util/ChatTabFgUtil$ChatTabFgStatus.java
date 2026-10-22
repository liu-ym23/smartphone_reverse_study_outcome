package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes35.dex */
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/util/ChatTabFgUtil$ChatTabFgStatus;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ChatTabFgUtil$ChatTabFgStatus {
    public static final a Companion = null;
    public static final int DISABLE = 0;
    public static final int ENABLE = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f414355a = null;

        static {
            f414355a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f414355a;
    }
}
