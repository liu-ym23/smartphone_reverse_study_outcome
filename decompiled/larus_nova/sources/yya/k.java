package yya;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<MessageActionType> f569511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f569512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<MessageActionType, List<d>> f569513d;

    public /* synthetic */ k(List r100, int r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = 0;
    L5:
        this("", r100, r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(String r100, List<? extends MessageActionType> r101, int r102, Map<MessageActionType, ? extends List<d>> r103) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        this.f569510a = r100;
        this.f569511b = r101;
        this.f569512c = r102;
        this.f569513d = r103;
    }
}
