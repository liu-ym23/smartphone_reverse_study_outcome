package mc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface k {
    void a(ArrayList<Document> r100);

    void b(ArrayList<Document> r100);

    void delete(String r100);

    FolderSortStrategy getFilter();
}
