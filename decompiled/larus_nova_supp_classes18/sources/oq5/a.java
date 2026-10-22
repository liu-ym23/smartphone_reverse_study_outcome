package oq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends kq5.a {

    /* JADX INFO: renamed from: oq5.a$a, reason: collision with other inner class name */
    public static final class C0285a {
    }

    static {
    }

    @Override // kq5.a
    public final String d() {
        return "RelationDecoration-SpaceWiki#1";
    }

    public a(ResultCode r2) {
        Intrinsics.checkNotNullParameter(r2, "resultCode");
        super(r2);
    }

    @Override // kq5.a
    public final void e(String r2, WikiRelation.Tree r3) {
        Intrinsics.checkNotNullParameter(r2, "virtualNodeToken");
        Intrinsics.checkNotNullParameter(r3, "parentTree");
        r3.spaceRootToken = r2;
    }
}
