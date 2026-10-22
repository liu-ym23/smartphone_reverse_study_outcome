package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/NavBarItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "toString", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavBarItem implements NonProguard {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f237399id;

    public NavBarItem() {
    }

    public String toString() {
        return "NavBarItem(id=" + this.f237399id + ')';
    }

    public final String getId() {
        return this.f237399id;
    }

    public final void setId(String r100) {
        this.f237399id = r100;
    }
}
