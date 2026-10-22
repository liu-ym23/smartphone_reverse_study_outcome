package um4;

import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import java.util.List;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes15.dex */
public interface a {
    Flow<List<FileEntry>> load();
}
