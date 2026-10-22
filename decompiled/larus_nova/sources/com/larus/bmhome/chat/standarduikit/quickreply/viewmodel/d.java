package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tm8.o;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b f309575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c f309576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<QuickReplyItem> f309577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f309578d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final QuickReplyItem f309579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f309580b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f309579a, r101.f309579a) == true) goto L12;
            return false;
        L12:
            if (this.f309580b == r101.f309580b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f309579a.hashCode() * 31;
            if (this.f309580b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "VisibleQuickReplyItem(item=" + this.f309579a + ", clicked=" + this.f309580b + ')';
        }

        public b(QuickReplyItem r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f309579a = r100;
            this.f309580b = r101;
        }
    }

    public static final class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f309581a;

        @Override // tm8.o
        public final void a() {
            d r100 = this.f309581a;
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r101 = r100.f309575a;
            if (r101 != null) goto L5;
            return;
        L5:
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c r102 = r100.f309576b;
            if (r102 == null) goto L9;
            r102.c(r101);
            return;
        }

        public c(d r100) {
            this.f309581a = r100;
        }

        @Override // tm8.o
        public final void b(int r100, int r101) {
            d r102 = this.f309581a;
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r103 = r102.f309575a;
            if (r103 != null) goto L5;
            return;
        L5:
            QuickReplyItem r104 = (QuickReplyItem) CollectionsKt.getOrNull(r102.f309577c, r100);
            if (r104 != null) goto L8;
            return;
        L8:
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c r105 = this.f309581a.f309576b;
            if (r105 == null) goto L12;
            r105.a(r103, r104, r101);
            return;
        }

        @Override // tm8.o
        public final void c(int r100, int r101, Context r110) {
            d r102 = this.f309581a;
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r103 = r102.f309575a;
            if (r103 != null) goto L5;
            return;
        L5:
            QuickReplyItem r104 = (QuickReplyItem) CollectionsKt.getOrNull(r102.f309577c, r100);
            if (r104 != null) goto L8;
            return;
        L8:
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c r105 = this.f309581a.f309576b;
            if (r105 == null) goto L12;
            r105.b(r103, r104, r101, r110, r100);
            return;
        }
    }

    static {
    }

    public d() {
        this.f309577c = CollectionsKt.emptyList();
        this.f309578d = new c(this);
    }
}
