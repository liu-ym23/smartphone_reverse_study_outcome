package com.ss.android.lark.chat.preview.actions;

import android.content.DialogInterface;
import com.ss.android.lark.chat.entity.preview.ShowDialogAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShowDialogAction.a f415986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f415987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f415988c;

    public c(ShowDialogAction.a r100, b r101, int r102) {
        this.f415986a = r100;
        this.f415987b = r101;
        this.f415988c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        String r102 = this.f415986a.f415353c;
        if (r102 == null) goto L10;
        b r103 = this.f415987b;
        int r104 = this.f415988c;
        Map<String, UrlPreviewAction> r105 = r103.f415980e;
        if (r105 == null) goto L7;
        UrlPreviewAction r106 = r105.get(r102);
    L8:
        a.a(r106, r102, null, r103.f415979d, null).a(r104 + 1);
        return;
    L7:
        r106 = null;
        goto L8
    }
}
