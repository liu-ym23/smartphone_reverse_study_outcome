package com.bytedance.upc;

import android.app.Activity;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&J&\u0010\u000e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\fH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/upc/IDialog;", "", "", "id", "Landroid/app/Activity;", "activity", "Lcom/bytedance/upc/j;", "iUpcDialog", "", "showDialog", "", "disMissDialog", "", "config", "tryCheckPrivacy", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public interface IDialog {
    void disMissDialog(String r100);

    boolean showDialog(String r100, Activity r101, j r102);

    void tryCheckPrivacy(Activity r100, Map<String, Object> r101);
}
