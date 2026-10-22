package oq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends kq5.a {

    /* JADX INFO: renamed from: oq5.a$a, reason: collision with other inner class name */
    public static final class C7093a {
    }

    static {
    }

    @Override // kq5.a
    public final String d() {
        return "RelationDecoration-SpaceWiki#1";
    }

    public a(ResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        super(r100);
    }

    @Override // kq5.a
    public final void e(String r100, WikiRelation.Tree r101) {
        Intrinsics.checkNotNullParameter(r100, "virtualNodeToken");
        Intrinsics.checkNotNullParameter(r101, "parentTree");
        r101.spaceRootToken = r100;
    }
}
