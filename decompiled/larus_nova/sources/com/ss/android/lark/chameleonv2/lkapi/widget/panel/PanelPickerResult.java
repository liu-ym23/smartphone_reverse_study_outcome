package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelPickerResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", "", "ids", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getIds", "()Ljava/util/List;", "setIds", "(Ljava/util/List;)V", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelPickerResult implements NonProguard {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f411501id;
    private List<String> ids;

    /* JADX WARN: Multi-variable type inference failed */
    public PanelPickerResult() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getId() {
        return this.f411501id;
    }

    public final List<String> getIds() {
        return this.ids;
    }

    public final void setId(String r100) {
        this.f411501id = r100;
    }

    public final void setIds(List<String> r100) {
        this.ids = r100;
    }

    public PanelPickerResult(String r100, List<String> r101) {
        this.f411501id = r100;
        this.ids = r101;
    }

    public /* synthetic */ PanelPickerResult(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
