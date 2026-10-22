package com.ss.android.lark.biz.im.api.bundle.v2.base.input;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;", "Landroid/os/Parcelable;", "type", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput$LaunchDataType;", "isValid", "", "toDesc", "", "LaunchDataType", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatEntityLaunchData;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatIdLaunchData;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatLaunchParamData;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatterIdLaunchData;", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILaunchDataInput extends Parcelable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput$LaunchDataType;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_ID", "CHATTER_ID", "CHAT", "CHAT_EQUAL_DATA", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LaunchDataType extends Enum<LaunchDataType> {
        public static final LaunchDataType CHAT = null;
        public static final LaunchDataType CHATTER_ID = null;
        public static final LaunchDataType CHAT_EQUAL_DATA = null;
        public static final LaunchDataType CHAT_ID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchDataType[] f409980a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f409981b = null;

        public static EnumEntries<LaunchDataType> getEntries() {
            return f409981b;
        }

        static {
            LaunchDataType r100 = new LaunchDataType("CHAT_ID", 0);
            CHAT_ID = r100;
            LaunchDataType r101 = new LaunchDataType("CHATTER_ID", 1);
            CHATTER_ID = r101;
            LaunchDataType r102 = new LaunchDataType("CHAT", 2);
            CHAT = r102;
            LaunchDataType r103 = new LaunchDataType("CHAT_EQUAL_DATA", 3);
            CHAT_EQUAL_DATA = r103;
            LaunchDataType[] r104 = {r100, r101, r102, r103};
            f409980a = r104;
            f409981b = EnumEntriesKt.enumEntries(r104);
        }

        public static LaunchDataType[] values() {
            return (LaunchDataType[]) f409980a.clone();
        }

        public static LaunchDataType valueOf(String r100) {
            return (LaunchDataType) r27.a.a(LaunchDataType.class, r100);
        }

        public LaunchDataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean isValid();

    LaunchDataType type();

    String x0();
}
