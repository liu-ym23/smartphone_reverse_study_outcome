package x8c;

import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.eventbus.BaseEvent;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends BaseEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Todo f562961a;

    public e(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, IOfflineExtraParser.ParserType.TODO);
        this.f562961a = r100;
    }
}
