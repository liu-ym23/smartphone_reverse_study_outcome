package q3b;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends x4b.a<MessageInfo> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f531563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Boolean> f531564e;

    public e(List<? extends MessageInfo> r100, List<Integer> r101, List<Integer> r102, int r103, Map<String, Boolean> r104) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        Intrinsics.checkNotNullParameter(r101, "invisiblePositions");
        Intrinsics.checkNotNullParameter(r102, "missingPositions");
        Intrinsics.checkNotNullParameter(r104, "syncPipeFinishMap");
        super(r100, r101, r102);
        this.f531563d = r103;
        this.f531564e = r104;
    }
}
