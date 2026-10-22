package com.ss.android.lark.chat.message.menu.v2.popup;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
public interface IPopupMenuContent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "SELF", "CHILD", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShadowTarget extends Enum<ShadowTarget> {
        public static final ShadowTarget CHILD = null;
        public static final ShadowTarget NONE = null;
        public static final ShadowTarget SELF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShadowTarget[] f415769a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415770b = null;

        public static EnumEntries<ShadowTarget> getEntries() {
            return f415770b;
        }

        static {
            ShadowTarget r100 = new ShadowTarget(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ShadowTarget r101 = new ShadowTarget("SELF", 1);
            SELF = r101;
            ShadowTarget r102 = new ShadowTarget("CHILD", 2);
            CHILD = r102;
            ShadowTarget[] r103 = {r100, r101, r102};
            f415769a = r103;
            f415770b = EnumEntriesKt.enumEntries(r103);
        }

        public static ShadowTarget[] values() {
            return (ShadowTarget[]) f415769a.clone();
        }

        public static ShadowTarget valueOf(String r100) {
            return (ShadowTarget) r27.a.a(ShadowTarget.class, r100);
        }

        public ShadowTarget(String r100, int r101) {
            super(r100, r101);
        }
    }

    PanelType getPanelType();

    ShadowTarget getShadowTarget();
}
