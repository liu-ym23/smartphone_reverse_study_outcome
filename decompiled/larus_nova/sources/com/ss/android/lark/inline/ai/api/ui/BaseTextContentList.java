package com.ss.android.lark.inline.ai.api.ui;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B1\u0012\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0007H\u0016R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/BaseTextContentList;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "paramDetails", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", CommonConstant.KEY_DISPLAY_NAME, "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getParamDetails", "()Ljava/util/ArrayList;", "setParamDetails", "(Ljava/util/ArrayList;)V", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseTextContentList<T> implements Serializable {
    private String displayName;
    private ArrayList<T> paramDetails;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseTextContentList() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        ArrayList<T> r100 = getParamDetails();
        String r101 = "";
        if (r100 == null) goto L9;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        r101 = r101 + r102.next();
    L9:
        return "TextContentList(paramDetails=" + r101 + ", displayName=" + getDisplayName() + ')';
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ArrayList<T> getParamDetails() {
        return this.paramDetails;
    }

    public void setDisplayName(String r100) {
        this.displayName = r100;
    }

    public void setParamDetails(ArrayList<T> r100) {
        this.paramDetails = r100;
    }

    public BaseTextContentList(ArrayList<T> r100, String r101) {
        this.paramDetails = r100;
        this.displayName = r101;
    }

    public /* synthetic */ BaseTextContentList(ArrayList r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
