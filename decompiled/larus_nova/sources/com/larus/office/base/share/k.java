package com.larus.office.base.share;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.larus.bmhome.share.ShareScene;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<km5.a, ShareScene> f361151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<km5.a, com.larus.bmhome.share.panel.h> f361152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<ShareItemModel, km5.a, String> f361153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f361154d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f361155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f361156b;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f361155a == r101.f361155a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361156b, r101.f361156b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f361155a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f361156b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "ActiveSharePanelSession(hasReportedPanelShow=" + this.f361155a + ", reportedChannels=" + this.f361156b + ')';
        }

        public a(Object r100) {
            LinkedHashSet r101 = new LinkedHashSet();
            Intrinsics.checkNotNullParameter(r101, "reportedChannels");
            this.f361155a = false;
            this.f361156b = r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function1<? super km5.a, ? extends ShareScene> r100, Function1<? super km5.a, com.larus.bmhome.share.panel.h> r101, Function2<? super ShareItemModel, ? super km5.a, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "resolveHostShareScene");
        Intrinsics.checkNotNullParameter(r101, "buildSharePanelEventParam");
        Intrinsics.checkNotNullParameter(r102, "mapShareItemToTraceChannel");
        this.f361151a = r100;
        this.f361152b = r101;
        this.f361153c = r102;
    }
}
