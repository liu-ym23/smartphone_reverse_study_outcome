package com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime;

import android.text.TextUtils;
import com.ss.android.lark.diskmanage.NonProguard;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeWatch;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "source", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeSource;", "getSource", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeSource;", "setSource", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeSource;)V", "equals", "", "other", "", "hashCode", "", "clone", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifiedTimeWatch implements NonProguard {
    public static final a Companion = null;
    public static final String WATCH_TYPE_ALL = "all";
    public static final String WATCH_TYPE_SPECIFIC = "specific";
    private ModifiedTimeSource source;
    private String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ModifiedTimeWatch() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type, this.source});
    }

    public final ModifiedTimeWatch clone() {
        ModifiedTimeWatch r100 = new ModifiedTimeWatch();
        r100.type = this.type;
        ModifiedTimeSource r101 = this.source;
        if (r101 == null) goto L5;
        ModifiedTimeSource r102 = r101.clone();
    L6:
        r100.source = r102;
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public final ModifiedTimeSource getSource() {
        return this.source;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (r100 == null) goto L5;
        Class<?> r101 = r100.getClass();
    L7:
        if (Intrinsics.areEqual(ModifiedTimeWatch.class, r101) == true) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch");
        ModifiedTimeWatch r102 = (ModifiedTimeWatch) r100;
        if (TextUtils.equals(this.type, r102.type) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.source, r102.source) == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final void setSource(ModifiedTimeSource r100) {
        this.source = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
