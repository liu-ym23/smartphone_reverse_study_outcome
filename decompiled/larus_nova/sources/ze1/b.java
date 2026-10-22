package ze1;

import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ij0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj0.c f571510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj0.a f571511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f571512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<BackupSeiModel> f571513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f571514e;

    public interface a {
        void a(BackupSeiModel r100, long r101, long r102);
    }

    @Override // ij0.a
    public final List<BackupSeiModel> b() {
        return this.f571513d;
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f571514e = r100;
        this.f571510a = new jj0.c(this);
        this.f571511b = new jj0.a(this);
        this.f571512c = true;
        this.f571513d = new ArrayList();
    }

    @Override // ij0.a
    public final void a(BackupSeiModel r100, long r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "seiModel");
        this.f571514e.a(r100, r101, r110);
    }
}
