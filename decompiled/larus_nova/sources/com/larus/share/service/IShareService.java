package com.larus.share.service;

import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/larus/share/service/IShareService;", "", "showSlidesShareFragment", "Landroidx/fragment/app/DialogFragment;", "shareContext", "Lcom/larus/share/bean/SlideShareContext;", "showSheetShareFragment", "Lcom/larus/share/bean/SheetShareContext;", "showDriveShareFragment", "Lcom/larus/share/bean/DriveShareContext;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IShareService {
    DialogFragment a(kw9.b r100);

    DialogFragment b(kw9.f r100);

    DialogFragment c(kw9.i r100);
}
