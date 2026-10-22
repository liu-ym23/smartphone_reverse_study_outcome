package com.bytedance.locallife.host.btm;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class SaasBtmItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f258854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f258855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f258856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SaasPageFinder f258857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f258858e;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0007J\u0012\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/host/btm/SaasBtmItem$SaasBtmItemBuilder;", "", "", "value", "setAddBtmChain", "", "setBtmChainLength", "Landroid/view/View;", "withView", "withBtmPage", "Lcom/bytedance/locallife/host/btm/SaasBtmItem;", "build", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class SaasBtmItemBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SaasBtmItem f258859a;

        public SaasBtmItemBuilder() {
            this("", null);
        }

        public final SaasBtmItem build() {
            return this.f258859a;
        }

        public final SaasBtmItemBuilder setAddBtmChain(boolean r100) {
            this.f258859a.f258856c = r100;
            return this;
        }

        public final SaasBtmItemBuilder setBtmChainLength(int r100) {
            this.f258859a.f258858e = r100;
            return this;
        }

        public final SaasBtmItemBuilder withBtmPage(Object r100) {
            this.f258859a.f258857d.f258861b = r100;
            return this;
        }

        public final SaasBtmItemBuilder withView(View r100) {
            this.f258859a.f258857d.f258862c = r100;
            return this;
        }

        public SaasBtmItemBuilder(String r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "btm");
            SaasBtmItem r102 = new SaasBtmItem();
            this.f258859a = r102;
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            r102.f258854a = r100;
            r102.f258855b = r101;
        }
    }

    public SaasBtmItem() {
        this.f258854a = "";
        this.f258857d = new SaasPageFinder();
        this.f258858e = 10;
    }
}
