package com.larus.ivykit.forest;

import com.larus.avlink.gallery.gecko.MorphoGeckoFileHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019JE\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\nH&Jb\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u001326\u0010\t\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030\u0014H&JC\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\nH&J$\u0010\u0018\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006\u001a"}, d2 = {"Lcom/larus/ivykit/forest/IFlowForestService;", "", "loadAsync", "", "bundleOrUrl", "", "channel", "onlyLocal", "", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "filePath", "downloadResAsync", "tag", "channels", "", "priority", "", "Lkotlin/Function2;", "success", "errorMessage", "getResPath", "loadSync", "Companion", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowForestService {

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a {
        public static /* synthetic */ String a(IFlowForestService r100, String r101) {
            return r100.b(r101, "flow_center_action_icon", false);
        }
    }

    String b(String r100, String r101, boolean r102);

    void c(String r100, com.larus.avlink.gallery.gecko.a r101);

    void d(String r100, String r101, boolean r102, Function1<? super String, Unit> r103);

    void e(String r100, List r101, int r102, MorphoGeckoFileHelper.a r103);
}
