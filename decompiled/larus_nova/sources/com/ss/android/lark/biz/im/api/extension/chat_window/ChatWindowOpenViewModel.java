package com.ss.android.lark.biz.im.api.extension.chat_window;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface ChatWindowOpenViewModel extends l3c.g, f {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ComponentReplaceWith;", "", "<init>", "(Ljava/lang/String;I)V", "ORIGINAL_COMPONENT", "SECRET_COMPONENT", "FAKE_CHAT_COMPONENT", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ComponentReplaceWith extends Enum<ComponentReplaceWith> {
        public static final ComponentReplaceWith FAKE_CHAT_COMPONENT = null;
        public static final ComponentReplaceWith ORIGINAL_COMPONENT = null;
        public static final ComponentReplaceWith SECRET_COMPONENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ComponentReplaceWith[] f410082a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410083b = null;

        public static EnumEntries<ComponentReplaceWith> getEntries() {
            return f410083b;
        }

        static {
            ComponentReplaceWith r100 = new ComponentReplaceWith("ORIGINAL_COMPONENT", 0);
            ORIGINAL_COMPONENT = r100;
            ComponentReplaceWith r101 = new ComponentReplaceWith("SECRET_COMPONENT", 1);
            SECRET_COMPONENT = r101;
            ComponentReplaceWith r102 = new ComponentReplaceWith("FAKE_CHAT_COMPONENT", 2);
            FAKE_CHAT_COMPONENT = r102;
            ComponentReplaceWith[] r103 = {r100, r101, r102};
            f410082a = r103;
            f410083b = EnumEntriesKt.enumEntries(r103);
        }

        public static ComponentReplaceWith[] values() {
            return (ComponentReplaceWith[]) f410082a.clone();
        }

        public static ComponentReplaceWith valueOf(String r100) {
            return (ComponentReplaceWith) r27.a.a(ComponentReplaceWith.class, r100);
        }

        public ComponentReplaceWith(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "", "<init>", "(Ljava/lang/String;I)V", "UN_INITIALIZED", "INITIALIZING", "INITIALIZED", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InitializeState extends Enum<InitializeState> {
        public static final InitializeState INITIALIZED = null;
        public static final InitializeState INITIALIZING = null;
        public static final InitializeState UN_INITIALIZED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InitializeState[] f410084a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410085b = null;

        public static EnumEntries<InitializeState> getEntries() {
            return f410085b;
        }

        static {
            InitializeState r100 = new InitializeState("UN_INITIALIZED", 0);
            UN_INITIALIZED = r100;
            InitializeState r101 = new InitializeState("INITIALIZING", 1);
            INITIALIZING = r101;
            InitializeState r102 = new InitializeState("INITIALIZED", 2);
            INITIALIZED = r102;
            InitializeState[] r103 = {r100, r101, r102};
            f410084a = r103;
            f410085b = EnumEntriesKt.enumEntries(r103);
        }

        public static InitializeState[] values() {
            return (InitializeState[]) f410084a.clone();
        }

        public static InitializeState valueOf(String r100) {
            return (InitializeState) r27.a.a(InitializeState.class, r100);
        }

        public InitializeState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static void a(String r100, Class r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "clazz");
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "clazz");
        }

        public static void c(String r100, Class r101, MutableLiveData r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "clazz");
            Intrinsics.checkNotNullParameter(r102, "liveData");
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "clazz");
            Intrinsics.checkNotNullParameter(r102, "liveData");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void b(ChatWindowOpenViewModel r100, String r101, Class<T> r102, LifecycleOwner r103, Observer<T> r104) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "clazz");
            Intrinsics.checkNotNullParameter(r103, "owner");
            Intrinsics.checkNotNullParameter(r104, "observer");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "clazz");
            Intrinsics.checkNotNullParameter(r103, "owner");
            Intrinsics.checkNotNullParameter(r104, "observer");
            MutableLiveData<T> r105 = r100.getLiveData(r101, r102);
            if (r105 == null) goto L6;
            r105.observe(r103, r104);
            return;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Replace with Flow or LiveData")
    public interface b {
    }

    MutableLiveData<Chat> getChat();

    fxa.b getChatBundle();

    MutableLiveData<i7b.a> getInitData();

    MutableLiveData<InitializeState> getInitializeStateLiveData();
}
