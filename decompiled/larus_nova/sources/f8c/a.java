package f8c;

import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtBean;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends AtBean {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f475938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f475939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f475940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f475941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f475942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TagData f475943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f475944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f475945j;

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtBean
    public final String a() {
        return this.f475944i;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtBean
    public int getType() {
        return this.f475945j;
    }

    public a(String r100, String r101, String r102, String r103, String r104, String r105, int r106, TagData r107) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "localizeName");
        Intrinsics.checkNotNullParameter(r102, "aliasName");
        Intrinsics.checkNotNullParameter(r103, "anotherName");
        Intrinsics.checkNotNullParameter(r104, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r105, "avatarKey");
        super(r106);
        this.f475937b = r100;
        this.f475938c = r101;
        this.f475939d = r102;
        this.f475940e = r103;
        this.f475941f = r104;
        this.f475942g = r105;
        this.f475943h = r107;
        this.f475944i = r100;
        this.f475945j = 1;
    }
}
