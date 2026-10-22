package com.bytedance.ee.bear.more.moreprotocol;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "Lcom/bytedance/ee/util/io/NonProguard;", "action", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction$MoreAction;", "msg", "", "<init>", "(Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction$MoreAction;Ljava/lang/String;)V", "getAction", "()Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction$MoreAction;", "getMsg", "()Ljava/lang/String;", "MoreAction", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreUiAction implements NonProguard {
    private final MoreAction action;
    private final String msg;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction$MoreAction;", "", "<init>", "(Ljava/lang/String;I)V", "NO_ACTION", "UNEAABLE_TIPS", "PERM_PLATFORM_ACTION", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MoreAction extends Enum<MoreAction> {
        public static final MoreAction NO_ACTION = null;
        public static final MoreAction PERM_PLATFORM_ACTION = null;
        public static final MoreAction UNEAABLE_TIPS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MoreAction[] f234663a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f234664b = null;

        public static EnumEntries<MoreAction> getEntries() {
            return f234664b;
        }

        static {
            MoreAction r100 = new MoreAction("NO_ACTION", 0);
            NO_ACTION = r100;
            MoreAction r101 = new MoreAction("UNEAABLE_TIPS", 1);
            UNEAABLE_TIPS = r101;
            MoreAction r102 = new MoreAction("PERM_PLATFORM_ACTION", 2);
            PERM_PLATFORM_ACTION = r102;
            MoreAction[] r103 = {r100, r101, r102};
            f234663a = r103;
            f234664b = EnumEntriesKt.enumEntries(r103);
        }

        public static MoreAction[] values() {
            return (MoreAction[]) f234663a.clone();
        }

        public static MoreAction valueOf(String r100) {
            return (MoreAction) a.a(MoreAction.class, r100);
        }

        public MoreAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final MoreAction getAction() {
        return this.action;
    }

    public final String getMsg() {
        return this.msg;
    }

    public MoreUiAction(MoreAction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.action = r100;
        this.msg = r101;
    }
}
