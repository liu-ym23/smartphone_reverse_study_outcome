package ze1;

import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiLinkFrequencyOptConfig f571527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BackupSeiModel> f571528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f571529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f571530d;

    public static final class a {
    }

    public interface b {
        void b(BackupSeiMessage r100, List<BackupSeiModel> r101, List<BackupSeiModel> r102);
    }

    static {
    }

    public h(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f571530d = r100;
        this.f571527a = v2.f65430a.getValue();
        this.f571528b = new ArrayList();
    }
}
