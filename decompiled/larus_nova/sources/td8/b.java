package td8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: td8.b$a$a, reason: collision with other inner class name */
        public static final class C7712a<T> implements Comparator {
            public C7712a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                return ComparisonsKt.compareValues(Integer.valueOf(((PipelineTaskProvider) r100).order()), Integer.valueOf(((PipelineTaskProvider) r101).order()));
            }
        }

        public static List<c> a(b r100, d r101, PipelineTaskType r102) {
            Intrinsics.checkNotNullParameter(r101, "taskContext");
            Intrinsics.checkNotNullParameter(r102, "type");
            Set r103 = ServiceManager.get().getServices(PipelineTaskProvider.class, true);
            if (r103 != null) goto L5;
            r103 = SetsKt.emptySet();
        L5:
            ArrayList r104 = new ArrayList();
            Iterator r105 = r103.iterator();
        L7:
            if (r105.hasNext() == false) goto L16;
            Object r106 = r105.next();
            PipelineTaskProvider r107 = (PipelineTaskProvider) r106;
            if (r107.stage() == r100.stage()) goto L11;
        L13:
            boolean r108 = false;
        L14:
            if (r108 == false) goto L7;
            r104.add(r106);
            goto L7
        L11:
            if (r107.type() != r102) goto L13;
            r108 = true;
            goto L14
        L16:
            List r109 = CollectionsKt.sortedWith(r104, new C7712a());
            ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
            Iterator r111 = r109.iterator();
        L18:
            if (r111.hasNext() == false) goto L20;
            r110.add(((PipelineTaskProvider) r111.next()).a(r101));
            goto L18
        L20:
            FLogger r112 = FLogger.f375446a;
            StringBuilder r113 = new StringBuilder();
            r113.append(r100.stage().name());
            r113.append('[');
            r113.append(r102.name());
            r113.append("] : ");
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
            Iterator r115 = r110.iterator();
        L22:
            if (r115.hasNext() == false) goto L24;
            r114.add(Reflection.getOrCreateKotlinClass(((c) r115.next()).getClass()).getSimpleName());
            goto L22
        L24:
            r113.append(r114);
            r112.d("Pipeline_IStage_collectTask", r113.toString());
            return CollectionsKt.toMutableList(r110);
        }
    }

    com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r100);

    void b();

    PipelineTaskStageEnum stage();
}
