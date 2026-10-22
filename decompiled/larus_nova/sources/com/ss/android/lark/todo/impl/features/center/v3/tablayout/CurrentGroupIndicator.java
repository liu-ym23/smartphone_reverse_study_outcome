package com.ss.android.lark.todo.impl.features.center.v3.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.feed.app.tablayout.RefactoredCurrentGroupIndicator;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002 !B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/CurrentGroupIndicator;", "Lcom/ss/android/lark/feed/app/tablayout/RefactoredCurrentGroupIndicator;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentFilter", "Lcom/ss/android/lark/todo/impl/features/center/v3/type/ContainerType;", "getCurrentFilter", "()Lcom/ss/android/lark/todo/impl/features/center/v3/type/ContainerType;", "setCurrentFilter", "(Lcom/ss/android/lark/todo/impl/features/center/v3/type/ContainerType;)V", "dependency", "Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/CurrentGroupIndicator$IDependency;", "getDependency", "()Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/CurrentGroupIndicator$IDependency;", "setDependency", "(Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/CurrentGroupIndicator$IDependency;)V", "updateCurrentFilter", "", "type", "filterItem", "", "Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/FilterItem;", "uiMode", "Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/CurrentGroupIndicator$UIMode;", "badeCount", "", "name", "", "IDependency", "UIMode", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CurrentGroupIndicator extends RefactoredCurrentGroupIndicator {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ContainerType f441738x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f441739y;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/tablayout/CurrentGroupIndicator$UIMode;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "NORMAL_LIST", "SECONDARY_LIST_WITH_DRAWER", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UIMode extends Enum<UIMode> {
        public static final UIMode NONE = null;
        public static final UIMode NORMAL_LIST = null;
        public static final UIMode SECONDARY_LIST_WITH_DRAWER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UIMode[] f441740a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441741b = null;

        public static EnumEntries<UIMode> getEntries() {
            return f441741b;
        }

        static {
            UIMode r100 = new UIMode(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            UIMode r101 = new UIMode("NORMAL_LIST", 1);
            NORMAL_LIST = r101;
            UIMode r102 = new UIMode("SECONDARY_LIST_WITH_DRAWER", 2);
            SECONDARY_LIST_WITH_DRAWER = r102;
            UIMode[] r103 = {r100, r101, r102};
            f441740a = r103;
            f441741b = EnumEntriesKt.enumEntries(r103);
        }

        public static UIMode[] values() {
            return (UIMode[]) f441740a.clone();
        }

        public static UIMode valueOf(String r100) {
            return (UIMode) r27.a.a(UIMode.class, r100);
        }

        public UIMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public final ContainerType getCurrentFilter() {
        return this.f441738x;
    }

    public final a getDependency() {
        return this.f441739y;
    }

    public CurrentGroupIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void g(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setText(r100);
    }

    public final void setCurrentFilter(ContainerType r100) {
        this.f441738x = r100;
    }

    public final void setDependency(a r100) {
        this.f441739y = r100;
    }

    public CurrentGroupIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
