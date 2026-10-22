package com.ss.android.lark.biz.im.api.extension.message;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes34.dex */
public interface IMessageResourcePreloadTask {

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/message/IMessageResourcePreloadTask$Scene;", "", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scene {
        public static final String CHAT = "chat";
        public static final String CHAT_THREAD = "chat_thread";
        public static final a Companion = null;
        public static final String REPLY_IN_THREAD = "reply_in_thread";
        public static final String SECRET_CHAT = "secret_chat";
        public static final String THREAD_DETAIL = "thread_detail";
        public static final String THREAD_WINDOW = "thread_window";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f410196a = null;

            static {
                f410196a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f410196a;
        }
    }

    void b();

    boolean c(Set<? extends MessageInfo> r100);

    boolean d(Message.Type r100);

    boolean e(Set<? extends MessageInfo> r100, IGetDataCallback<Map<String, String>> r101);

    boolean f();

    Set<String> getScenes();

    String getTaskType();

    void isEnabled();
}
