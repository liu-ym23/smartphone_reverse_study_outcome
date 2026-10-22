package mc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface k {
    void a(ArrayList<Document> r1);

    void b(ArrayList<Document> r1);

    void delete(String r1);

    FolderSortStrategy getFilter();
}
