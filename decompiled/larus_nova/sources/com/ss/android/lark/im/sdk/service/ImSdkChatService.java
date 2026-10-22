package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.integrator.im.impl.ChatApiImpl$selectMessagesFromChat$1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface ImSdkChatService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/im/sdk/service/ImSdkChatService$Source;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT_WINDOW", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source CHAT_WINDOW = null;
        public static final Source UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f426002a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426003b = null;
        private final int value;

        public static EnumEntries<Source> getEntries() {
            return f426003b;
        }

        static {
            Source r100 = new Source("UNKNOWN", 0, 1);
            UNKNOWN = r100;
            Source r101 = new Source("CHAT_WINDOW", 1, 2);
            CHAT_WINDOW = r101;
            Source[] r102 = {r100, r101};
            f426002a = r102;
            f426003b = EnumEntriesKt.enumEntries(r102);
        }

        public static Source[] values() {
            return (Source[]) f426002a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f426004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ProfileSource f426005b;

        public a() {
            this(false, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f426004a == r101.f426004a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f426005b, r101.f426005b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f426004a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            ProfileSource r102 = this.f426005b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "CreateP2pChatParams(isSecretChat=" + this.f426004a + ", profileSource=" + this.f426005b + ')';
        }

        public a(boolean r100, ProfileSource r101) {
            this.f426004a = r100;
            this.f426005b = r101;
        }
    }

    Chat B2(String r100);

    void C2(List<String> r100, IGetDataCallback<Map<String, Chat>> r101);

    com.ss.android.lark.chat.entity.chat.b I0(String r100);

    Chat P6(String r100, Source r101);

    void X5(String r100, a r101, IGetDataCallback<Chat> r102);

    void Y6(List<String> r100, String r101, IGetDataCallback<Map<String, Boolean>> r102);

    Chat getLocalChat(String r100);

    String getOtherP2PChatterId(Chat r100);

    com.ss.android.lark.chat.entity.chat.a nd(String r100);

    void uc(List r100, ChatApiImpl$selectMessagesFromChat$1 r101);

    Chat we(String r100);

    Chat xc(String r100);
}
