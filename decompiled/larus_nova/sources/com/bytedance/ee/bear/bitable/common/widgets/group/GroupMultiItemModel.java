package com.bytedance.ee.bear.bitable.common.widgets.group;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "groupId", "", "(Ljava/lang/String;)V", "id", "getId", "()Ljava/lang/String;", "setId", "getGroupId", "setGroupId", "groupPosition", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel$GroupPosition;", "getGroupPosition", "()Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel$GroupPosition;", "setGroupPosition", "(Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel$GroupPosition;)V", "GroupPosition", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class GroupMultiItemModel implements NonProguard {
    private transient String groupId;
    private GroupPosition groupPosition;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private transient String f209961id;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel$GroupPosition;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "TOP", "CENTER", "BOTTOM", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GroupPosition extends Enum<GroupPosition> {
        public static final GroupPosition BOTTOM = null;
        public static final GroupPosition CENTER = null;
        public static final GroupPosition SINGLE = null;
        public static final GroupPosition TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupPosition[] f209962a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f209963b = null;

        public static EnumEntries<GroupPosition> getEntries() {
            return f209963b;
        }

        static {
            GroupPosition r100 = new GroupPosition("SINGLE", 0);
            SINGLE = r100;
            GroupPosition r101 = new GroupPosition("TOP", 1);
            TOP = r101;
            GroupPosition r102 = new GroupPosition("CENTER", 2);
            CENTER = r102;
            GroupPosition r103 = new GroupPosition("BOTTOM", 3);
            BOTTOM = r103;
            GroupPosition[] r104 = {r100, r101, r102, r103};
            f209962a = r104;
            f209963b = EnumEntriesKt.enumEntries(r104);
        }

        public static GroupPosition[] values() {
            return (GroupPosition[]) f209962a.clone();
        }

        public static GroupPosition valueOf(String r100) {
            return (GroupPosition) a.a(GroupPosition.class, r100);
        }

        public GroupPosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    public GroupMultiItemModel() {
        this.groupPosition = GroupPosition.SINGLE;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public final GroupPosition getGroupPosition() {
        return this.groupPosition;
    }

    public String getId() {
        return this.f209961id;
    }

    public GroupMultiItemModel(String r100) {
        this.groupPosition = GroupPosition.SINGLE;
        setGroupId(r100);
    }

    public void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setGroupPosition(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupPosition = r100;
    }

    public void setId(String r100) {
        this.f209961id = r100;
    }
}
