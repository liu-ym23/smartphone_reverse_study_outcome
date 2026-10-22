package ur7;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.value.SpecialChar;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public class d extends c {
    public final void c() {
        Set<SpecialChar> r100 = this.f551385c.f547315f;
        HashSet r101 = (HashSet) r100;
        r101.add(SpecialChar.QUESTION_MARK);
    }

    public d(com.cronutils.model.definition.a r100, CronFieldName r101) {
        super(r100, r101);
    }
}
