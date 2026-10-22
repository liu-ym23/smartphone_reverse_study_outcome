package x8c;

import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.eventbus.BaseEvent;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends BaseEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Todo f562956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f562959d;

    public a(Todo r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, IOfflineExtraParser.ParserType.TODO);
        Intrinsics.checkNotNullParameter(r101, "containerGuid");
        Intrinsics.checkNotNullParameter(r102, "sectionGuid");
        Intrinsics.checkNotNullParameter(r103, "rank");
        this.f562956a = r100;
        this.f562957b = r101;
        this.f562958c = r102;
        this.f562959d = r103;
    }
}
