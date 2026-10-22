package kotlin.reflect.jvm.internal.impl.renderer;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class KeywordStringsGenerated {
    public static final Set<String> KEYWORDS = null;

    static {
        KEYWORDS = new HashSet(Arrays.asList(new String[]{"package", "as", "typealias", "class", "this", "super", "val", "var", "fun", SlcElement.KEY_FOR, "null", "true", "false", "is", "in", "throw", "return", "break", "continue", "object", "if", "try", "else", "while", SRStrategy.KEY_DOWNGRADE, RemoteMessageConst.Notification.WHEN, "interface", "typeof"}));
    }
}
