package xf8;

import com.larus.im.bean.message.Message;
import com.larus.ivykit.plugin.TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f563524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TemplateInfo f563525f;

    @Override // xc8.b
    public final int d() {
        return this.f563525f.getGravity();
    }

    public i(Message r100, TemplateInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxMessage");
        Intrinsics.checkNotNullParameter(r101, "templateInfo");
        super(r100);
        this.f563524e = r100;
        this.f563525f = r101;
    }
}
