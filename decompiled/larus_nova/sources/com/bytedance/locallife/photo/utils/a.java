package com.bytedance.locallife.photo.utils;

import com.ss.android.ugc.aweme.poi.event.POI_PREVIEW_DIALOG_SHOW_EVENT;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements com.bytedance.locallife.photo.photodraweeview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiBundle f262349a;

    @Override // com.bytedance.locallife.photo.photodraweeview.a
    public final void a() {
        vn6.b.a(new POI_PREVIEW_DIALOG_SHOW_EVENT(this.f262349a.sessionId, "show"));
    }

    @Override // com.bytedance.locallife.photo.photodraweeview.a
    public final void onDialogDismiss() {
        vn6.b.a(new POI_PREVIEW_DIALOG_SHOW_EVENT(this.f262349a.sessionId, "dismiss"));
    }

    public a(PoiBundle r100) {
        this.f262349a = r100;
    }
}
