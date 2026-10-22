package com.ss.android.lark.biz.im.api.extension.chat_window;

import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.scaffold.IComponent;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0006\u000f\u0010\u0011\u0012\u0013\u0014J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/lark/scaffold/IComponent;", "setMeetingRoleProvider", "", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$MeetingRoleProvider;", "getTheme", "Lcom/ss/android/lark/chat/entity/theme/TitleTheme;", "getLeftArea", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$LeftArea;", "getCenterArea", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$CenterArea;", "getRightArea", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$RightArea;", "MeetingRoleProvider", "LeftArea", "CenterArea", "RightArea", "TitleBarMetaInfo", "CenterViewProvider", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ChatWindowTitleBar extends LifecycleOwner, IComponent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$TitleBarMetaInfo;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_NAME", "ARROW_ICON", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TitleBarMetaInfo extends Enum<TitleBarMetaInfo> {
        public static final TitleBarMetaInfo ARROW_ICON = null;
        public static final TitleBarMetaInfo CHAT_NAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitleBarMetaInfo[] f410088a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410089b = null;

        public static EnumEntries<TitleBarMetaInfo> getEntries() {
            return f410089b;
        }

        static {
            TitleBarMetaInfo r100 = new TitleBarMetaInfo("CHAT_NAME", 0);
            CHAT_NAME = r100;
            TitleBarMetaInfo r101 = new TitleBarMetaInfo("ARROW_ICON", 1);
            ARROW_ICON = r101;
            TitleBarMetaInfo[] r102 = {r100, r101};
            f410088a = r102;
            f410089b = EnumEntriesKt.enumEntries(r102);
        }

        public static TitleBarMetaInfo[] values() {
            return (TitleBarMetaInfo[]) f410088a.clone();
        }

        public static TitleBarMetaInfo valueOf(String r100) {
            return (TitleBarMetaInfo) r27.a.a(TitleBarMetaInfo.class, r100);
        }

        public TitleBarMetaInfo(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(FrameLayout r100);
    }

    FlowTitleBarComponent.RightAreaImpl F00();

    FlowTitleBarComponent.a XA();

    TitleTheme getTheme();

    FlowTitleBarComponent.LeftAreaImpl x00();
}
