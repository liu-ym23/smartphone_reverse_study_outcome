package z7c;

import android.content.Context;
import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends UDBaseDialogBuilder<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<SelectFieldOption> f570755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<SelectFieldOption> f570756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f570757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f570758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f570759e;

    public interface a {
        void a();
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570755a = CollectionsKt.emptyList();
        this.f570756b = CollectionsKt.emptyList();
        gravity(80);
    }
}
