package com.ss.android.lark.picker;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/IPicker;", "CONFIG", "", "init", "", "config", "(Ljava/lang/Object;)V", "reload", "isReloadSearch", "", "isReloadRecommend", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPicker<CONFIG> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void reload$default(IPicker r100, boolean r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = true;
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = true;
        L9:
            r100.reload(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reload");
        }
    }

    void init(CONFIG r100);

    void reload(boolean r100, boolean r101);
}
