package eq4;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.larus.platform.model.SlashMentionConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f473489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f473490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AttachmentEntity f473491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<? extends AttachmentEntity> f473492d;

    public static final class a {
    }

    static {
    }

    public final String b() {
        if (this.f473491c.getName().length() > 35) goto L7;
        String r100 = this.f473491c.getName();
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return yu5.c.k(this.f473491c.getName(), 35) + "...";
    }

    public final h a() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.view.description.embedimage.EmbedImage");
        return (h) r100;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public h(int r100, int r101, AttachmentEntity r102, List<? extends AttachmentEntity> r103) {
        Intrinsics.checkNotNullParameter(r102, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        this.f473489a = r100;
        this.f473490b = r101;
        this.f473491c = r102;
        this.f473492d = r103;
    }
}
