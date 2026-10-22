package t18;

import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParamContainer;
import com.larksuite.framework.apiplugin.validator.format.Max;
import com.larksuite.framework.apiplugin.validator.format.MaxContainer;
import com.larksuite.framework.apiplugin.validator.format.Min;
import com.larksuite.framework.apiplugin.validator.format.MinContainer;
import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import com.larksuite.framework.apiplugin.validator.format.NotBlankContainer;
import com.larksuite.framework.apiplugin.validator.format.NumberEnum;
import com.larksuite.framework.apiplugin.validator.format.NumberEnumContainer;
import com.larksuite.framework.apiplugin.validator.format.Pattern;
import com.larksuite.framework.apiplugin.validator.format.PatternContainer;
import com.larksuite.framework.apiplugin.validator.format.Prefix;
import com.larksuite.framework.apiplugin.validator.format.PrefixContainer;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import com.larksuite.framework.apiplugin.validator.format.StringEnumContainer;
import com.larksuite.framework.apiplugin.validator.format.Suffix;
import com.larksuite.framework.apiplugin.validator.format.SuffixContainer;
import com.larksuite.framework.apiplugin.validator.format.Valid;
import com.larksuite.framework.apiplugin.validator.format.ValidContainer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<? extends Annotation>, a<? extends Annotation>> f544164a = null;

    public interface a<T extends Annotation> {
        List<v18.a> a(Field r100, Object r101, T r102, w18.a r103);
    }

    static {
        HashMap r100 = new HashMap();
        f544164a = r100;
        r100.put(Max.class, new t18.a());
        r100.put(MaxContainer.class, new c());
        r100.put(Min.class, new d());
        r100.put(MinContainer.class, new e());
        r100.put(NotBlank.class, new f());
        r100.put(NotBlankContainer.class, new g());
        r100.put(NumberEnum.class, new h());
        r100.put(NumberEnumContainer.class, new i());
        r100.put(Pattern.class, new j());
        r100.put(PatternContainer.class, new k());
        r100.put(Prefix.class, new l());
        r100.put(PrefixContainer.class, new m());
        r100.put(StringEnum.class, new n());
        r100.put(StringEnumContainer.class, new o());
        r100.put(Suffix.class, new p());
        r100.put(SuffixContainer.class, new q());
        r100.put(LKRequiredParam.class, new r());
        r100.put(LKRequiredParamContainer.class, new s());
        r100.put(Valid.class, new t());
        r100.put(ValidContainer.class, new b());
    }
}
