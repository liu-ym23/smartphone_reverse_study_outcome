package com.bytedance.android.shopping.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\bI\u0010JR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102R$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR*\u00106\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R$\u00109\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R*\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010%\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R*\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010%\u001a\u0004\bA\u0010'\"\u0004\bB\u0010)R\"\u0010C\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010/\u001a\u0004\bD\u00100\"\u0004\bE\u00102R$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\b¨\u0006M"}, d2 = {"Lcom/bytedance/android/shopping/vo/AuthorReputationVO;", "Ljava/io/Serializable;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "score", "Ljava/lang/Double;", "getScore", "()Ljava/lang/Double;", "setScore", "(Ljava/lang/Double;)V", "", "level", "Ljava/lang/Integer;", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "ratingColor", "I", "getRatingColor", "()I", "setRatingColor", "(I)V", "rating", "getRating", "setRating", "sales", "getSales", "setSales", "", "salesTextString", "Ljava/util/List;", "getSalesTextString", "()Ljava/util/List;", "setSalesTextString", "(Ljava/util/List;)V", "precent", "getPrecent", "setPrecent", "", "isStore", "Z", "()Z", "setStore", "(Z)V", "fansCount", "getFansCount", "setFansCount", "fansCountText", "getFansCountText", "setFansCountText", "worksNum", "getWorksNum", "setWorksNum", "worksNumString", "getWorksNumString", "setWorksNumString", "Lcom/bytedance/android/ec/model/ECUrlModel;", "brandImgList", "getBrandImgList", "setBrandImgList", "showSales", "getShowSales", "setShowSales", "scoreNormalText", "getScoreNormalText", "setScoreNormalText", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuthorReputationVO implements Serializable {
    public static final a Companion = null;
    private List<? extends ECUrlModel> brandImgList;
    private String fansCount;
    private List<String> fansCountText;
    private boolean isStore;
    private Integer level;
    private String precent;
    private String rating;
    private int ratingColor;
    private String sales;
    private List<String> salesTextString;
    private Double score;
    private String scoreNormalText;
    private boolean showSales;
    private String text;
    private Integer worksNum;
    private List<String> worksNumString;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AuthorReputationVO() {
        this.ratingColor = -13257367;
        this.isStore = true;
        this.showSales = true;
    }

    public final List<ECUrlModel> getBrandImgList() {
        return this.brandImgList;
    }

    public final String getFansCount() {
        return this.fansCount;
    }

    public final List<String> getFansCountText() {
        return this.fansCountText;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final String getPrecent() {
        return this.precent;
    }

    public final String getRating() {
        return this.rating;
    }

    public final int getRatingColor() {
        return this.ratingColor;
    }

    public final String getSales() {
        return this.sales;
    }

    public final List<String> getSalesTextString() {
        return this.salesTextString;
    }

    public final Double getScore() {
        return this.score;
    }

    public final String getScoreNormalText() {
        return this.scoreNormalText;
    }

    public final boolean getShowSales() {
        return this.showSales;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getWorksNum() {
        return this.worksNum;
    }

    public final List<String> getWorksNumString() {
        return this.worksNumString;
    }

    public final boolean isStore() {
        return this.isStore;
    }

    public final void setBrandImgList(List<? extends ECUrlModel> r1) {
        this.brandImgList = r1;
    }

    public final void setFansCount(String r1) {
        this.fansCount = r1;
    }

    public final void setFansCountText(List<String> r1) {
        this.fansCountText = r1;
    }

    public final void setLevel(Integer r1) {
        this.level = r1;
    }

    public final void setPrecent(String r1) {
        this.precent = r1;
    }

    public final void setRating(String r1) {
        this.rating = r1;
    }

    public final void setRatingColor(int r1) {
        this.ratingColor = r1;
    }

    public final void setSales(String r1) {
        this.sales = r1;
    }

    public final void setSalesTextString(List<String> r1) {
        this.salesTextString = r1;
    }

    public final void setScore(Double r1) {
        this.score = r1;
    }

    public final void setScoreNormalText(String r1) {
        this.scoreNormalText = r1;
    }

    public final void setShowSales(boolean r1) {
        this.showSales = r1;
    }

    public final void setStore(boolean r1) {
        this.isStore = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setWorksNum(Integer r1) {
        this.worksNum = r1;
    }

    public final void setWorksNumString(List<String> r1) {
        this.worksNumString = r1;
    }
}
