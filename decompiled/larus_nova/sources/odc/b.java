package odc;

import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import ldc.e;

/* JADX INFO: loaded from: classes38.dex */
public interface b<DATA extends Photo, PLUGIN extends e<DATA>> {
    PLUGIN a(int r100);

    int getColumnCount();

    int getType(int r100, DATA r101);
}
